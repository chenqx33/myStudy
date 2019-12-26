package chenqx.newTest;


import chenqx.pojo.Book;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author chenqx 2019-11-26
 * @instruction
 */
public class Test8 {
    @Test
    public void should_(){
        Book book = new Book();
        LinkedList<Book> objects = Lists.newLinkedList();
        for (int i = 0; i < 100000000; i++) {
            objects.add(book);
        }
        objects.get(1).setAuth("1");
        System.out.println(objects.get(0));
    }
    @Test
    public void should_String(){
        String s = "1";
        String ss = "1".intern();
        System.out.println(s==ss);

    }
    @Test
    public void should_for(){
        ArrayList<Integer> objects = Lists.newArrayList(1,2,3);
        objects.forEach(o->{
            if (o==2)return;
            System.out.println(o);
        });
    }
}
