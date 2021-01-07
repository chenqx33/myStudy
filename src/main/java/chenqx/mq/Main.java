package chenqx.mq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chenqx 2020-02-29
 * @instruction
 */
public class Main {
    public static void main(String[] args) {
        //内存缓冲区
        BlockingQueue<Data> queue = new LinkedBlockingQueue<Data>(10);
        //生产者
        Provider p1 = new Provider(queue);
        Provider p2 = new Provider(queue);
        Provider p3 = new Provider(queue);

        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);

        //创建线程池，这是一个缓存的线程池，可以创建无穷大的线程，没有任务的时候不创建线程，空闲线程存活的时间为60s。
        ExecutorService cachepool = Executors.newCachedThreadPool();
        cachepool.execute(p1);
        cachepool.execute(p2);
        cachepool.execute(p3);
        cachepool.execute(c1);
        cachepool.execute(c2);
        cachepool.execute(c3);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p1.stop();
        p2.stop();
        p3.stop();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
