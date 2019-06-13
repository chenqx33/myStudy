package chenqx.newTest;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BigDecimaltest {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("-123.1234");
        BigDecimal bigDecimal1 = new BigDecimal("123.1234");
        System.out.println(bigDecimal.add(bigDecimal1));
        System.out.println(bigDecimal.abs());
        System.out.println(Integer.MAX_VALUE+2);
        Integer i = 2;
        Map<String,Boolean> map =  new HashMap<String, Boolean>();
        Boolean b = (map!=null ? map.get("test") : false);
        ArrayList<Object> objects = Lists.newArrayList();
    }
}
