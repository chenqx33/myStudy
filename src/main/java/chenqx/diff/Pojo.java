package chenqx.diff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-14 21:04
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pojo {
    private String name;
    private Integer age;
    private String sex;
    private List<Pojo> child;

    public Pojo(String name) {
        this.name = name;
    }
}
