package chenqx.newTest;

import chenqx.pojo.Book1;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author chenqx
 * @date 2019-08-01 14:55
 * @instruction
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String s = scanner.nextLine();
            System.out.println(s);
        }


    }

    @Test
    public void should_() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("chenqx.pojo.Book1");
        Book1 book1 = (Book1)aClass.newInstance();
        System.out.println(book1);
    }
}
