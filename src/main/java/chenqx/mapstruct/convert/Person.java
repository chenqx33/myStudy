package chenqx.mapstruct.convert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.cglib.beans.BeanMap;

import java.util.Date;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-01 18:54
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private long id;
    private String name;
    private String email;
    private Date birthday;
    private User user;

    public static void main(String[] args) {
        Person person = new Person(1L, "2", "3", new Date(), new User());
        BeanMap beanMap = BeanMap.create(person);
        System.out.println(beanMap.get("id"));
        beanMap.put("id",44L);
        System.out.println(beanMap.get("id"));
    }
}
