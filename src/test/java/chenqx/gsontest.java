package chenqx;

import chenqx.pojo.Book;
import com.google.gson.Gson;

import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;

import chenqx.pojo.MyClass;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void test3() throws IOException {
        //language=JSON
        String bookstr = "[\n" +
                "  {\n" +
                "    \"name\": \"xx\",\n" +
                "    \"auth\": \"xxx\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"xx1\",\n" +
                "    \"auth\": \"xxx1\"\n" +
                "  " +
                "}\n" +
                "]";
        List<Book> objects = stringToArray(bookstr, Book[].class);
        System.out.println(objects.get(0).getAuth());
    }

    private <T> List<T> fromJson(String str, Class<T> typeOfT) throws IOException {
        Gson gson = new Gson();
        List<T> list = null;
        list = gson.fromJson(str, new TypeToken<List<T>>() {
        }.getType());
        return list;
    }

    public static <T> List<T> stringToArray(String s, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr); //or return Arrays.asList(new Gson().fromJson(s, clazz)); for a one-liner
    }
}
