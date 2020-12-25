package chenqx.newTest;

import chenqx.pojo.Book;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author cqx
 * @date 2018/11/29 17:05
 */
@Ignore
public class BookTest {
    @Test
    public void memberTest(){
        List<Book> list = Lists.newArrayList(new Book("1","1"),new Book("2","2"));
        try {
            list.forEach(book->{
                if ("2".equals(book.getAuth())){
                    System.out.println("2");
                    throw new RuntimeException("2");
                }else {
                    System.out.println("1");
                    System.out.println("123");
                }
            });
        }catch (Exception e){
            System.out.println("12");
        }

    }

    @Test
    public void vv(){
        ArrayList<String> strings = Lists.newArrayList("1", "222", "22", "213");
        strings.sort(Comparator.comparingInt(String::length));
        System.out.println(strings);


        String[] aa = new String[]{"123","1234"};
        System.out.println(Arrays.toString(aa));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println(sdf.parse("2007 -11-12"));
        } catch (ParseException e) {


        }

    }


    @Test
    public void sss(){
        verifyConditions(JSON.parseObject("{\"type\":\"hasCondition\",\"value\":{\"=conditions\":[{\"type\":\"and\",\"conditions\":[{\"left\":{\"expression\":\"account_status\"},\"right\":{\"type\":{\"name\":\"select_one\"},\"value\":\"2\"},\"type\":\"EQ\"},{\"left\":{\"expression\":\"account_no\"},\"right\":{\"type\":{\"name\":\"text\"},\"value\":\"123123\"},\"type\":\"EQ\"}]},{\"type\":\"and\",\"conditions\":[{\"left\":{\"expression\":\"account_type\"},\"right\":{\"type\":{\"name\":\"select_one\"},\"value\":\"2\"},\"type\":\"EQ\"},{\"left\":{\"expression\":\"email\"},\"right\":{\"type\":{\"name\":\"email\"},\"value\":\"123123\"},\"type\":\"EQ\"}]}],\"type\":\"or\"}}").getJSONObject("value"));
    }



    public boolean verifyConditions(JSONObject rangeObj) {
        String type = rangeObj.getString("type");
        JSONArray conditionArr = rangeObj.getJSONArray("conditions");
        boolean result = false;
        for (Object o : conditionArr) {
            JSONObject obj = (JSONObject) o;
            if (obj.containsKey("conditions")) {
                result = verifyConditions( obj);
            } else {
                try {
                    result = verifyCondition(obj);
                } catch (Exception e) {
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * 1: 'EQ', //等于 2: 'N', //不等于 3: 'GT', //大于 4: 'GTE', //大于等于 5: 'LT', //小于 6: 'LTE', //小于等于 7:
     * 'LIKE', //包含 8: 'NLIKE', //不包含 9: 'IS', //为空 10: 'ISN', //不为空
     */
    private boolean verifyCondition(JSONObject condition) {
        String vfyFieldName = condition.getJSONObject("left").getString("expression");
        return false;
    }

}

