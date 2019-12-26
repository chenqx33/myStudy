package chenqx.pojo;

import lombok.experimental.Delegate;

public class BookCopy {
    @Delegate
    private Book book;

    public BookCopy(){
        book = new Book("1","2");
    }


    public static void main(String[] args) {
        BookCopy bookCopy = new BookCopy();
//        System.out.println(bookCopy.getName());
        System.out.println(bookCopy.getAuth());
    }
}
