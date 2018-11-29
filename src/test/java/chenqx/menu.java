package chenqx;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chenqx.pojo.Book;
import com.chenqx.pojo.MenuItemConfigObject;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author cqx
 * @date 2018/11/20 10:33
 */
public class menu {
    @Test
    public void menuu() throws IOException {
        String iconString = IOUtils.toString(getClass().getClassLoader().getResource("iconPath.json"), "UTF-8");
        ;
        String menuConfig = IOUtils.toString(getClass().getClassLoader().getResource("menuItemConfig.json"), "UTF-8");

        List<MenuItemConfigObject> menuItemConfigObjects = JSON.parseArray(menuConfig, MenuItemConfigObject.class);
        JSONObject jsonObject = JSON.parseObject(iconString);
        menuItemConfigObjects.forEach(o -> {
            o.setIcon_path_menu(null);
            o.setIcon_path_home(null);
        });
        menuItemConfigObjects.forEach(o -> {
            o.setIcon_path_home((String) jsonObject.get(o.getDisplay_name() + "大.png"));
            o.setIcon_path_menu((String) jsonObject.get(o.getDisplay_name() + "小.png"));
        });
        List<MenuItemConfigObject> o = (List<MenuItemConfigObject>) JSON.toJSON(menuItemConfigObjects);
        System.out.println(o);
    }

    @Test
    public void vvvv() throws IOException {
//        String json = IOUtils.toString(getClass().getClassLoader().getResource("test.json"), "UTF-8");
//        List<JSONObject> jsonArray = JSON.parseArray(json,JSONObject.class);
//        List<String> list = Lists.newArrayList();
//        for (JSONObject o : jsonArray) {
//            deal(o, list, "17");
//        }
//        System.out.println(list.toString());
        List<Book> list = Lists.newArrayList();
        Book book = new Book("1","1");
        list.add(book);
        List<Book> list2 = Lists.newCopyOnWriteArrayList(list);
        book.setAuth("2");
        list.add(book);
        System.out.println(list.toString());
        System.out.println(list2.toString());
        Set<String> set = Sets.newHashSet();
        set.add(null);
        set.add(null);
        System.out.println("2");


    }

    public void deal(JSONObject cate, List<String> ids, String id) {
        JSONArray children = cate.getJSONArray("Children");
        String cateId = cate.get("CategoryCode").toString();
        if (cateId.equals(id) || id == null) {
            if (children != null) {
                for (Object child : children) {
                    JSONObject childObj = (JSONObject) child;
                    deal(childObj, ids, null);
                }
            }
            ids.add(cateId);
        }else{
            if (children != null) {
                for (Object child : children) {
                    JSONObject childObj = (JSONObject) child;
                    deal(childObj, ids, id);
                }
            }
        }




    }
}
