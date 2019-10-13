package chenqx.redis;

import redis.clients.jedis.Jedis;

/**
 * @author chenqx 2019-09-29
 * @instruction
 */
public class Test {

    public static void main(String[] args) {
//        Jedis jedis = new Jedis("localhost", 6379, 100000);
        int i = 0;
        try (Jedis jedis = new Jedis("localhost", 6379, 100000);){
            long start = System.currentTimeMillis();//开始毫秒数
            while (true) {
                long end = System.currentTimeMillis();
                if (end - start >= 1000) {   //测试1s
                    break;
                }
                i++;
                jedis.set("test" + i, i + "");
            }
        } finally {
//            jedis.close();
        }
        System.out.println("redis每秒操作：" + i + "次");
    }
}
