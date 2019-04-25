package chenqx.pojo;

import org.junit.Test;

public class BookCopyTest {

    @Test
    public void t(){
        BookCopy bookCopy = new BookCopy();
        System.out.println(bookCopy);
        System.out.println("1".compareTo("1"));
        System.out.println("11".compareTo("101"));
        System.out.println("1".compareTo("2"));
    }

}