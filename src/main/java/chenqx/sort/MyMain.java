package chenqx.sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-06-09 16:21
 **/
public class MyMain {
    public static void main(String[] args) {
        ArrayList<Obj> objs = Lists.newArrayList(
                new Obj("chen", null),
                new Obj("zhang", 12L),
                new Obj("qian", 10L),
                new Obj("zhao", null)
        );
        objs.sort(Comparator.comparing(Obj::getAge,Comparator.nullsLast(Long::compareTo)).reversed());
        System.out.println(objs);
    }
}
