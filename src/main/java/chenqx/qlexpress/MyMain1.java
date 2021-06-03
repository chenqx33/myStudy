package chenqx.qlexpress;

import com.alibaba.fastjson.JSON;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import lombok.SneakyThrows;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2021/4/16 15:06
 **/
public class MyMain1 {
    private static ExpressRunner runner = new ExpressRunner();
    @SneakyThrows
    public static void main(String[] args) {
        DefaultContext cmd = JSON.parseObject("{}", DefaultContext.class);
        Object execute = runner.execute("1/0", cmd, null, true, false);
        System.out.println(execute.toString());
    }
}
