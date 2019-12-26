package chenqx.pojo;

public class hhaa extends hha {
    public Book book = new Book();

    private Book get(){
        return super.book;
    }
    public String say(){
        return "child";
    }

    public static void main(String[] args) {
        hhaa hh = new hhaa();

        System.out.println("d");
    }
}

