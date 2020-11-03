package chenqx.old;

import chenqx.pojo.Book;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author cqx
 * @date 2018/4/10 16:49
 */
public class Uknown {

    public static void main(String[] args) {
        ArrayList<Book> objects = Lists.newArrayList(new Book(), new Book());
        System.out.println(objects);
        CopyOnWriteArrayList<Book> objects1 = Lists.newCopyOnWriteArrayList(objects);
        objects1.get(0).setAuth("123");
        System.out.println(objects);
    }
}
