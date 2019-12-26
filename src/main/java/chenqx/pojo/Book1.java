package chenqx.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book1 implements Cloneable{
    private String auth;
    private String name;
    private Book book;

    @Override
    protected Book1 clone() throws CloneNotSupportedException {
        return (Book1)super.clone();
    }

    public Book1(String auth, String name) {
        this.auth = "1";
        this.name = "2";
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Book1 book1 = new Book1("a","b",new Book("1","2"));
        Book1 book2 = book1.clone();
        System.out.println(book1.getBook());
        book2.getBook().setAuth("11");
        System.out.println(book1.getBook());
        System.out.println(book1==book2);
    }
}
