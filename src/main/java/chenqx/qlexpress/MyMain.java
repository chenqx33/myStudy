package chenqx.qlexpress;

import chenqx.pojo.Book;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.cg.gcrm.common.tenant.formatter.cal.BackendFormat;
import com.bytedance.cg.gcrm.common.util.GsonUtils;
import com.bytedance.cg.gcrm.common.util.JsonUtils;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import joptsimple.internal.Strings;
import lombok.NonNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-28 17:42
 **/
public class MyMain {
    private static ExpressRunner runner = new ExpressRunner();
    static{
        try {
            runner.addFunctionOfClassMethod("timeFormat", BackendFormat.class.getName(),
                    "format", new Class[]{Object.class, String.class}, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //        public static void main(String[] args) throws Exception {
//        String msg = "{\"distributorCustomerRefNames\":[\"123\"],\"distributorCustomerRefs\":[\"123\"],
//        \"registeredCity\":\"789\",\"registeredArea\":null}";
//        DefaultContext cmd = JSON.parseObject(msg, DefaultContext.class);
//        String parse = parse(cmd, "s='';if (`distributorCustomerRefNames`!=null&&((List)
//        distributorCustomerRefNames).size()>0&&`distributorCustomerRefs`!=null&&((List)distributorCustomerRefs)
//        .size()>0){ s=distributorCustomerRefNames.get(0) +  \"(\" + distributorCustomerRefs.get(0)  +\")\"}");
//        System.out.println(parse);
//
//    }
//    public static void main(String[] args) throws Exception {
//        //language=JSON
//        String msg = "{\"values\":[{\"name\":\"value\"}],\"distributorCustomerRefs\":[\"123\"]," +
//                "\"registeredCity\":\"789\",\"registeredArea\":null}";
//        DefaultContext cmd = JSON.parseObject(msg, DefaultContext.class);
//        String parse = parse(cmd, "s='';if (values!=null&&((List)values).size()>0){ s=values.get(0).name}");
//        System.out.println(parse);
//
//    }
    public static void main(String[] args) throws Exception {
        String msg = "{\"ToB_ProductDemand\":\"销售预测\",\"authCoworkers\":[{\"role\":\"解决方案\"," +
                "\"roleI18Value\":\"解决方案\",\"employeeIds\":null,\"authType\":null,\"employeeDTOS\":[{\"id\":2897250," +
                "\"name\":\"马天武\",\"departmentName\":null},{\"id\":2298180,\"name\":\"赵景钰\",\"departmentName\":null}," +
                "{\"id\":3938867,\"name\":\"张中一\",\"departmentName\":null}]},{\"role\":\"coworker read\"," +
                "\"roleI18Value\":\"coworker read\",\"employeeIds\":null,\"authType\":null," +
                "\"employeeDTOS\":[{\"id\":7603372,\"name\":\"师超\",\"departmentName\":null},{\"id\":1226813," +
                "\"name\":\"文前波\",\"departmentName\":null}]}]}";

        DefaultContext cmd = JSON.parseObject(msg, DefaultContext.class);
//        String parse = parse(cmd,
//                "label = new StringBuilder();if (authCoworkers!=null&&((List)authCoworkers).size()>0){ for(i=0;" +
//                        "i<authCoworkers.size();i++){ label.append(authCoworkers.get(i).roleI18Value).append(\": \");" +
//                        "for(j=0;j<authCoworkers.get(i).employeeDTOS.size();j++){label.append(authCoworkers.get(i)" +
//                        ".employeeDTOS.get(j).name);if(j==authCoworkers.get(i).employeeDTOS.size()-1){label.append" +
//                        "(\"; \");}else{label.append(\", \")}}}}");
//        System.out.println(parse);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(1601192476000L));
        System.out.println(parse(cmd,"timeFormat(1601192476000L,\"yyyy-MM-dd\")"));
//        Joiner.on(",").join()
//        StringBuilder label = new StringBuilder();
//        for(i=0;i<authCoworkers.size();i++){
//            label.add(authCoworkers[i].roleI18Value);
//            label.append(authCoworkers[i].roleI18Value).append(":");
//            for (int j = 0; j < authCoworkers[i].employeeDTOS; j++) {
//                label.append(authCoworkers[i].employeeDTOS[j].name).append(",");
//            }
//            label.append(";");
//        }
    }

    private static String parse(@NonNull DefaultContext<String, Object> data,
                                @NonNull String formatter) throws Exception {
        return runner.execute(formatter, data, null, true, false).toString();

    }
    public static String format(Object object, String pattern) {
        return new SimpleDateFormat(pattern).format(object);
    }
}
