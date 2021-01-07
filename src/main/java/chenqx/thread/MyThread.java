package chenqx.thread;

/**
 * @author chenqx 2020-03-03
 * @instruction
 */
public class MyThread extends Thread {
    volatile private int count = 0;
    private volatile boolean b=true;
    private  void add(){
//        for (int i = 0; i < 1000; i++) {
//            count++;
//            System.out.println("count = " + count);
//            try {
//                Thread.sleep(5L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println("start");
        while (b){}
        System.out.println("end");
    }
    private void setB(boolean bb){
        b=bb;
    }
    @Override
    public void run() {
        add();
    }


    public static void main(String[] args) throws InterruptedException {
        MyThread demo = new MyThread();
        demo.start();
//        Thread t2 = new Thread(demo);
//        Thread t3 = new Thread(demo);
        Thread.sleep(3000);
        demo.setB(false);
        System.out.println("yifuzhi");
//        t2.start();
//        t3.start();
        demo.wait();
        demo.interrupt();
    }
}
