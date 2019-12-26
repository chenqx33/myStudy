package chenqx.filechange;

import org.apache.log4j.helpers.FileWatchdog;

/**
 * @author chenqx 2019-12-18
 * @instruction
 */
public class Log4jWatchdog {
    public static void main(String[] args) {
        Log4jWatchdog log4jWatchdog = new Log4jWatchdog();
        GloablConfig gloablConfig = new GloablConfig(log4jWatchdog.getClass().getClassLoader().getResource("a.json").getPath());
        gloablConfig.setDelay(1000);
        gloablConfig.start();
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
    public static class GloablConfig extends FileWatchdog {
        protected GloablConfig(String filename) {
            super(filename);
        }

        @Override
        protected void doOnChange() {

            System.out.println(filename);
        }

    }
}
