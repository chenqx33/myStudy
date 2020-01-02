package chenqx.arthas;

import chenqx.pojo.Book;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenqx 2019-12-27
 * @instruction
 */
public class MyMain {
    private static List<String> show(List<String> list ){
        return Lists.newArrayList(list.get(0));
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Book> books = Lists.newArrayList(new Book("1", "1"), new Book("1", null));

        Map<String, List<Book>> collect = books.stream().collect(Collectors.groupingBy(o -> o.getName()));
        System.out.println(collect);
    }

}
