package chenqx.main;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;

/**
 * @author chenqx 2019-10-23
 * @instruction
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        ArrayList<Integer> integers1 = Lists.newArrayList(integers);
        new Thread(()->{
            for (Integer integer : integers1) {
                System.out.println(integer);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        Thread.sleep(1000);

        integers.remove(0);
        System.out.println(integers);
        System.out.println(integers1);
    }
}
