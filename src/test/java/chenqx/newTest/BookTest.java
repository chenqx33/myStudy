package chenqx.newTest;

import com.google.common.collect.Lists;

import org.junit.Test;

import java.util.List;

import javax.xml.bind.SchemaOutputResolver;

import chenqx.pojo.Book;

/**
 * @author cqx
 * @date 2018/11/29 17:05
 */
public class BookTest {
    @Test
    public void memberTest(){
        List<Book> list = Lists.newArrayList(new Book("1","1"),new Book("2","2"));
        try {
            list.forEach(book->{
                if ("2".equals(book.getAuth())){
                    System.out.println("2");
                    throw new RuntimeException("2");
                }else {
                    System.out.println("1");
                }
            });
        }catch (Exception e){
            System.out.println("12");
        }

    }
}
