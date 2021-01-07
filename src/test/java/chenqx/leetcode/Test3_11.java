package chenqx.leetcode;

import chenqx.pojo.Book;
import org.junit.Test;

/**
 * @author chenqx 2020-03-11
 * @instruction
 */
public class Test3_11 {
    @Test
    public void should_1(){
        System.out.println(new Book());
        System.out.println(Book.builder().auth("11").build());
    }

}
