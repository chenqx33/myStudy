package chenqx.pojo;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-06-04 10:19
 **/
public class ClassError {
    private String name;
    final static List<String> children = Lists.newArrayList();

    public ClassError(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ClassError name = new ClassError("name");
        System.out.println(name);
    }
}
