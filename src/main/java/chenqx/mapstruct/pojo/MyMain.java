package chenqx.mapstruct.pojo;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-13 15:32
 **/
public class MyMain {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.setDescription("23");
        parent.setSysName("23");
        parent.setVersion(123);
        System.out.println(Mapp.INSTANCE.domain2dto(parent));
    }
}
