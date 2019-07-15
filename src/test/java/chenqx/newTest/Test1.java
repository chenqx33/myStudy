package chenqx.newTest;

import chenqx.http.HttpUtil;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Test1 {

    @Test
    public void ss() {
        List<Long> times = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            System.out.println(System.currentTimeMillis());
            times.add(System.currentTimeMillis());
        }
        Map<Long, Long> longLongMap = times.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        System.out.println(longLongMap);
    }

    @Test
    public void sss(){
        String s = HttpUtil.get("http://fanyi.youdao.com/openapi.do?keyfrom=Alfred&key=1963786550&type=data&doctype=json&version=1.1&q=大家好");
        String allMenu = "http://10.112.32.60:8234/API/v1/object/crm_menu/service/all_menu/";
        Header header = new BasicHeader("X-fs-Employee-Id","1000");
        Header header1 = new BasicHeader("X-fs-Enterprise-Id","71568");
        String post = HttpUtil.post(allMenu, "", new Header[]{header, header1});
        System.out.println(post);
        System.out.println(s);
    }

    @Test
    public void s(){
        System.out.println(stringToDouble(2,1));
        System.out.println(stringToDouble(null,1));
        System.out.println(stringToDouble("",1));
        System.out.println(stringToDouble("2",1));
    }

    private Double stringToDouble(Object value, Object defaultValue) {
        Double result;
        if (Objects.isNull( value)|| Strings.isNullOrEmpty(value.toString())) {
            result = Objects.isNull(defaultValue) ? Double.valueOf(1) : Double.valueOf(defaultValue.toString());
        } else {
            result = Double.valueOf(value.toString());
        }
        return result;
    }

}
