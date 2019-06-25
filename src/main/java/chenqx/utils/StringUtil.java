package chenqx.utils;

import chenqx.pojo.Book;
import com.alibaba.fastjson.JSON;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static String getMatcher(String regex, String source) {
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }

    public static void main(String[] args) {
////        String url = "http://172.12.1.123/test.txt";
//        String url = "123.txt";
////        String regex = "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})";
//        String regex = "";
//        System.out.println(getMatcher(regex,url));

        System.out.println("123.txt".substring("123.txt".lastIndexOf('.') + 1));

        JSON.parseArray("[{\"name\":\"1\"},{\"name\":\"1\"}{\"name\":\"1\"}]", Book.class);
        System.out.println("11");

    }
}
