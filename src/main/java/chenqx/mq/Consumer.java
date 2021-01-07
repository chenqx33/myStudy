package chenqx.mq;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author chenqx 2020-02-29
 * @instruction
 */
public class Consumer implements Runnable {
    private BlockingQueue<Data> queue;

    public Consumer(BlockingQueue queu){
        this.queue = queu;
    }

    //随机对象
    private static Random r = new Random();

    @Override
    public void run() {
        while(true){
            try{
                //获取数据
                Data data = this.queue.take();
                //进行数据处理，休眠 0-1000毫秒模拟耗时
                Thread.sleep(r.nextInt(1000));
                System.out.print("当前消费线程"+Thread.currentThread().getName() +",消费成功，消费id为"+data.getId());
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
