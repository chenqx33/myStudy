package chenqx.newTest;

import org.junit.Ignore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Ignore
public class NewTest {
    private static AtomicInteger i=new AtomicInteger();
    static Lock lock = new ReentrantLock();
    public static  void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(3);
        new Thread(){
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    add();
                }
                latch.countDown();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    add();
                }
                latch.countDown();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    add();
                }
                latch.countDown();
            }
        }.start();
        try {
            latch.await();
        }catch (Exception e){
            System.out.println(1);
        }

        System.out.println(i);
    }

    private static void add(){
        lock.lock();
        try {
            i.incrementAndGet();
        } finally{
            lock.unlock();
        }
    }

}
