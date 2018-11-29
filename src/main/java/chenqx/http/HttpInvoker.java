package chenqx.http;

import com.google.common.io.ByteStreams;

import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;
import java.util.Map;

/**
 * Created by luxin on 2018/7/18.
 * 封装了一个用于调用http接口的工具
 */
public class HttpInvoker {
    // 池化管理
    private static final PoolingHttpClientConnectionManager POOLING_HTTP_CLIENT_CONNECTION_MANAGER;

    private static CloseableHttpClient httpClient;
    // 请求器的配置
    private static final RequestConfig REQUEST_CONFIG;

    private final static Object SYNC_LOCK = new Object();
    static {
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
        // 初始化连接池
        POOLING_HTTP_CLIENT_CONNECTION_MANAGER = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        POOLING_HTTP_CLIENT_CONNECTION_MANAGER.setMaxTotal(200);
        POOLING_HTTP_CLIENT_CONNECTION_MANAGER.setDefaultMaxPerRoute(20);
        REQUEST_CONFIG = RequestConfig.custom().setConnectionRequestTimeout(10000).setSocketTimeout(10000).setConnectTimeout(10000).build();

        httpClient = getHttpClientInstance();
    }


    public static byte[] post(final String url, Map<String, String> header, String jsonBody) throws IOException {
        CloseableHttpClient httpClient = getHttpClientInstance();

        HttpPost httpPost = new HttpPost(url);
        byte[] body = jsonBody.getBytes();

        final ByteArrayEntity entity = new ByteArrayEntity(body, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        header.forEach((k, v) -> {
            httpPost.setHeader(k, v);

        });

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            final StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() >= 400) {
                throw new IOException(statusLine.toString());
            }

            return ByteStreams.toByteArray(response.getEntity().getContent());
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }


    private static CloseableHttpClient getHttpClientInstance() {
        synchronized (SYNC_LOCK) {
            if (httpClient == null) {
                httpClient = HttpClients.custom()
                        .setConnectionManager(POOLING_HTTP_CLIENT_CONNECTION_MANAGER)
                        .setDefaultRequestConfig(REQUEST_CONFIG)
                        .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                        .build();
            } else {
                return httpClient;
            }
        }
        return httpClient;
    }


    private HttpInvoker() {

    }

}
