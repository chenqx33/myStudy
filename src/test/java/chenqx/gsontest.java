package chenqx;

import com.google.gson.Gson;

import org.junit.Test;

import chenqx.pojo.MyClass;

import static org.junit.Assert.assertEquals;

/**
 * @author cqx
 * @date 2018/12/19 16:24
 */
public class gsontest {
    @Test
    public void test() {
        MyClass target = new MyClass("v1", "v2", "v3");
        Gson gson = new Gson();
        String json = gson.toJson(target);
        System.out.println(json);
    }

    @Test
    public void test2() {
        Gson gson = new Gson();
        MyClass target = gson.fromJson("{'name1':'v1'}", MyClass.class);
        assertEquals("v1", target.b);
        target = gson.fromJson("{'name2':'v2'}", MyClass.class);
        assertEquals("v2", target.b);
        target = gson.fromJson("{'name3':'v3'}", MyClass.class);
        assertEquals("v3", target.b);
    }
}
