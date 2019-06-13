package chenqx.newTest;

import chenqx.pojo.Book;
import com.google.common.collect.Lists;

import java.util.List;

public class NewTest {
    public static void main(String[] args) {
        List<Book> list = Lists.newArrayList(new Book());
        list.stream().findFirst().ifPresent(o->o.setAuth("123"));
        System.out.println(list);
    }
}
