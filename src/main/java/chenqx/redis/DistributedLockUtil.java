package chenqx.redis;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-04-21 11:23
 **/
public class DistributedLockUtil {

    private DistributedLockUtil(){
    }

    public static boolean lock(String lockName){//lockName可以为共享变量名，也可以为方法名，主要是用于模拟锁信息
        System.out.println(Thread.currentThread() + "开始尝试加锁！");
        Long result = RedisPoolUtil.setnx(lockName, String.valueOf(System.currentTimeMillis() + 5000));
        if (result != null && result.intValue() == 1){
            System.out.println(Thread.currentThread() + "加锁成功！");
            RedisPoolUtil.expire(lockName, 5);
            System.out.println(Thread.currentThread() + "执行业务逻辑！");
            RedisPoolUtil.del(lockName);
            return true;
        } else {
            String lockValueA = RedisPoolUtil.get(lockName);
            if (lockValueA != null && Long.parseLong(lockValueA) <= System.currentTimeMillis()){
                String lockValueB = RedisPoolUtil.getSet(lockName, String.valueOf(System.currentTimeMillis() + 5000));
                if (lockValueB == null || lockValueB.equals(lockValueA)){
                    System.out.println(Thread.currentThread() + "加锁成功！");
                    RedisPoolUtil.expire(lockName, 5);
                    System.out.println(Thread.currentThread() + "执行业务逻辑！");
                    RedisPoolUtil.del(lockName);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
