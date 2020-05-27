package chenqx.mapstruct.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.cglib.beans.BeanMap;

import java.io.IOException;
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
    private String email="1234";
    private Date birthday;
    private User user;

    public static void main(String[] args) throws IOException {
        Person person = new Person(1L, "2", "3", new Date(), new User());
        BeanMap beanMap = BeanMap.create(person);
        System.out.println(beanMap.get("id"));
        beanMap.put("id",44L);
        System.out.println(beanMap.get("id"));

        String jsonStr = "{\"id\":123,\"name\":\"123c\"}";
        ObjectMapper mapper = new ObjectMapper();
        Person person1 = mapper.readValue(jsonStr, person.getClass());
        System.out.println(person1);
    }
}
