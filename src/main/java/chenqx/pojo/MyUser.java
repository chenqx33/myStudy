package chenqx.pojo;

import lombok.Data;

/**
 * @author chenqx 2019-10-14
 * @instruction
 */
@Data
public class MyUser extends User {

    private String name;

    public MyUser(String name, String arg) {
        super(name, arg);
    }
}
