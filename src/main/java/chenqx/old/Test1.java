package chenqx.old;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {

    public static ExecutorService executorService = Executors.newFixedThreadPool(5);
    public static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Task task1 = new Task();
        Task task2 = new Task();
        executorService.execute(task1);
        executorService.execute(task2);
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                calculate();
            }
        }

        private void calculate() {
            int i = 0;
            while (true) {
                i++;
            }
        }
    }
}
