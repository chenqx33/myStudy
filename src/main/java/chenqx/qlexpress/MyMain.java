package chenqx.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-28 17:42
 **/
public class MyMain {
    public static void main(String[] args) throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a",1);
        context.put("b",2);
        context.put("c",3);
        String express = "a+b*c";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }
}
