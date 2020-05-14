package chenqx.redis;

import redis.clients.jedis.Jedis;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-04-21 11:22
 * setnx(key, value)：“set if not exits”，若该key-value不存在，则成功加入缓存并且返回1，否则返回0。
 *
 * get(key)：获得key对应的value值，若不存在则返回nil。
 *
 * getset(key, value)：先获取key对应的value值，若不存在则返回nil，然后将旧的value更新为新的value。
 *
 * expire(key, seconds)：设置key-value的有效期为seconds秒。
 **/
public class RedisPoolUtil {

    private RedisPoolUtil(){}

    private static RedisPool redisPool;

    public static String get(String key){
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.get(key);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
            return result;
        }
    }

    public static Long setnx(String key, String value){
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.setnx(key, value);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
            return result;
        }
    }

    public static String getSet(String key, String value){
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.getSet(key, value);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
            return result;
        }
    }

    public static Long expire(String key, int seconds){
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.expire(key, seconds);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
            return result;
        }
    }

    public static Long del(String key){
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.del(key);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
            return result;
        }
    }
}
