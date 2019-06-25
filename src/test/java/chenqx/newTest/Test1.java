package chenqx.newTest;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test1 {

    @Test
    public void ss() {
        List<Long> times = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            System.out.println(System.currentTimeMillis());
            times.add(System.currentTimeMillis());
        }
        Map<Long, Long> longLongMap = times.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        System.out.println(longLongMap);
    }

    @Test
    public void sss(){
       Object o =1;
        System.out.println(o.toString());
    }
}
