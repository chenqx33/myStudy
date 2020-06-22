package chenqx.qlexpress;

import com.alibaba.fastjson.JSON;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import lombok.NonNull;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-28 17:42
 **/
public class MyMain {
    private static ExpressRunner runner = new ExpressRunner();

    public static void main(String[] args) throws Exception {
        String msg = "{\"distributorCustomerRefNames\":[\"123\"],\"distributorCustomerRefs\":[\"123\"],\"registeredCity\":\"789\",\"registeredArea\":null}";
        DefaultContext cmd = JSON.parseObject(msg, DefaultContext.class);
        String parse = parse(cmd, "s='';if (distributorCustomerRefNames!=null&&((List)distributorCustomerRefNames).size()>0&&distributorCustomerRefs!=null&&((List)distributorCustomerRefs).size()>0){ s=distributorCustomerRefNames.get(0) +  \"(\" + distributorCustomerRefs.get(0)  +\")\"}");
        System.out.println(parse);

    }

    private static String parse(@NonNull DefaultContext<String, Object> data,
                                @NonNull String formatter) throws Exception {
        return runner.execute(formatter, data, null, true, false).toString();

    }
}
