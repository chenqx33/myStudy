package chenqx.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-07-30 14:32
 **/
public class CopyTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        A a = new A(1,null,"age");
        B b = new B(2,"name",null);
        BeanUtils.copyProperties(a,b);
        System.out.println(a);
        System.out.println(b);
    }
    @ToString
    @AllArgsConstructor
    @Getter
    @Setter
    static class A{
        private int id;
        private String name;
        private String age;
    }
    @ToString
    @AllArgsConstructor
    @Getter
    @Setter
    static class B{
        private int id;
        private String name;
        private String age;
    }
}
