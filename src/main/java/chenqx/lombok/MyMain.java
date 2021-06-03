package chenqx.lombok;

import com.google.common.collect.Lists;
import lombok.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * @see Cleanup 局部变量回收时，调用变量的close()
 * @see Generated 用来标记方法、类等是用工具生成的
 * @see Cleanup 局部变量回收时，调用变量的close()
 * @see Cleanup 局部变量回收时，调用变量的close()
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2021/4/9 19:51
 **/

public class MyMain {
    @SneakyThrows
    @Synchronized
    public static void main(String[] args) {
        @Cleanup
        Foo foo = new Foo();
        System.out.println(foo);
//        throw new Exception("xx");
        Foo build = Foo.builder().name("xx").names(Lists.newArrayList("x")).build();
        System.out.println(build);
    }
}
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Foo {
    @Singular
    List<String> names;
    public void close(){
        System.out.println("xxx");
    }
}