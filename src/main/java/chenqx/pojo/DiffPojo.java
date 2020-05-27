package chenqx.pojo;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-21 16:51
 **/
@Data
@AllArgsConstructor
public class DiffPojo {
    private String operator;
    private Boolean toSort;

    public static void main(String[] args) {
        System.out.println(JSON.toJSON(new DiffPojo("",false)));
        System.out.println(JSON.toJSON(new DiffPojo("",false)));
        System.out.println(JSON.toJSON(new DiffPojo("",false)));
        System.out.println(JSON.toJSON(new DiffPojo("",false)));
        System.out.println(JSON.toJSON(new DiffPojo("",false)));
    }
}
