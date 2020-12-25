package chenqx.pojo.test;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-12-18 16:12
 **/
public class POJO {

    public static void main(String[] args) {
        final POJO1 pojo1 = new POJO1();
        pojo1.setName(123);
        final POJO2 pojo2 = new POJO2();
        BeanUtils.copyProperties(pojo1, pojo2);
        System.out.println(pojo2);
    }
}

@Data
class POJO1 {
    private Integer name;

    public POJO1() {
        System.out.println("pojo1");
    }
}

@Data
class POJO2 {
    private Integer name;

    public POJO2() {
        System.out.println("pojo2");
    }
}

class POJO3 {
    public POJO3() {
        System.out.println("pojo3");
    }
}