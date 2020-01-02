package chenqx.pojo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class Book implements Serializable {
    private String auth;
    private String name;

    public void service() {
        System.out.println("作者：" + auth);
        System.out.println("书名：" + name);
    }

    public Book(String auth, String name) {
        this.auth = auth;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.auth.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return auth.equals(((Book)obj).getAuth());
    }

    public static Object ofList(List<Book> bookList){
        return JSON.toJSON(bookList);
    }

    public static void main(String[] args) {
        ArrayList<Book> books = Lists.newArrayList(new Book("1", "1"), new Book("2", "2"));
        Object o = Book.ofList(books);
        System.out.println((List<HashMap>)o);
    }
}
