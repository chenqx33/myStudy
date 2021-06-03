package chenqx.test;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.IOException;

/**
 * @description:aa
 * @version: 1.0
 * @author: chenqixin
 * @create: 2021/3/26 18:27
 **/
public class MyMain {
    public static void main(String[] args) throws IOException {
        System.out.println(JSON.parseObject("{}",a.class));
        System.out.println(new a());
    }
}
@Data
class a{
    private boolean b;
}