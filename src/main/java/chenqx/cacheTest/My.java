package chenqx.cacheTest;

import com.bytedance.cg.gcrm.common.util.ThreadLocalCache;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-12-04 20:49
 **/
public class My {
    public static void main(String[] args) {
        Cache<Object, Object> build = CacheBuilder.newBuilder().build();
        build.put("1","one");
        build.cleanUp();
        System.out.println();
    }
}
