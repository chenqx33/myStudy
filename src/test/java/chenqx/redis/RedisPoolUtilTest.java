package chenqx.redis;

import org.junit.Test;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-04-21 11:39
 **/
public class RedisPoolUtilTest {
    @Test
    public void should_getSyc() throws InterruptedException {
        RedisPoolUtil.setnx("123", "123a");
        System.out.println(RedisPoolUtil.get("123"));
        RedisPoolUtil.expire("123", 1);
        Thread.sleep(2000L);
        System.out.println(RedisPoolUtil.get("123"));
        System.out.println(RedisPoolUtil.setnx("123", "123b"));
        System.out.println(RedisPoolUtil.get("123"));
        System.out.println(RedisPoolUtil.getSet("123", "123c"));
        System.out.println(RedisPoolUtil.del("123"));
        System.out.println(RedisPoolUtil.getSet("123", "123c"));
        System.out.println(RedisPoolUtil.get("123"));
    }

}