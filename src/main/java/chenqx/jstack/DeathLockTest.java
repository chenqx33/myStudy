package chenqx.jstack;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2021/4/30 16:29
 **/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java 死锁demo
 */
public class DeathLockTest {
    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void deathLock() {
        Thread t1 = new Thread(() -> {
            try {
                lock1.lock();
                System.out.println(Thread.currentThread().getName() + " get the lock1");
                Thread.sleep(1000);
                lock2.lock();
                System.out.println(Thread.currentThread().getName() + " get the lock2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                lock2.lock();
                System.out.println(Thread.currentThread().getName() + " get the lock2");
                Thread.sleep(1000);
                lock1.lock();
                System.out.println(Thread.currentThread().getName() + " get the lock1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //设置线程名字，方便分析堆栈信息
        t1.setName("mythread-jay");
        t2.setName("mythread-tianluo");
        t1.start();
        t2.start();
    }
    public static void main(String[] args) {
        deathLock();
    }
}