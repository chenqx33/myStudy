package chenqx.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenqx 2020-03-02
 * @instruction
 */
public class MapTest {
    @Test
    public void should_1(){
        Map<String,String> map = new LinkedHashMap<>();
        map.put("2","22");
        map.put("1","11");
        map.put("3","33");
        System.out.println(map);
        System.out.println(map.keySet());
        Map<String,String> map1 = new HashMap<>();
        map1.put("2","22");
        map1.put("1","11");
        map1.put("3","33");
        System.out.println(map1);
        System.out.println(map1.keySet());
    }
}
