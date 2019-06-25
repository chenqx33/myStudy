package chenqx;

import chenqx.pojo.MenuItemConfigObject;
import chenqx.pojo.spec;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cqx
 * @date 2018/11/20 10:33
 */
public class menu {
    @Test
    public void menuu() throws IOException {
        String iconString = IOUtils.toString(getClass().getClassLoader().getResource("iconPath.json"), "UTF-8");

        String menuConfig = IOUtils.toString(getClass().getClassLoader().getResource("menuItemConfig.json"), "UTF-8");

        List<MenuItemConfigObject> menuItemConfigObjects = JSON.parseArray(menuConfig, MenuItemConfigObject.class);
        JSONObject jsonObject = JSON.parseObject(iconString);
        menuItemConfigObjects.forEach(o -> {
            o.setIcon_path_menu(null);
            o.setIcon_path_home(null);
        });
        menuItemConfigObjects.forEach(o -> {
            o.setIcon_path_home((String) jsonObject.get(o.getDisplay_name() + ".svg"));
            o.setIcon_path_menu((String) jsonObject.get(o.getDisplay_name() + ".svg"));
        });
        List<MenuItemConfigObject> o = (List<MenuItemConfigObject>) JSON.toJSON(menuItemConfigObjects);
        System.out.println(o);
    }

    @Test
    public void vvvv() throws IOException {
        String iconString = IOUtils.toString(getClass().getClassLoader().getResource("b.json"), "UTF-8");

        List<spec> menuItemConfigObjects = JSON.parseArray(iconString, spec.class);
        for (int i = 0; i < menuItemConfigObjects.size(); i++) {
            spec spec = menuItemConfigObjects.get(i);
            spec.setName(String.valueOf(i)+"我就是笑哈哈的测试");
            spec.setOrder_field(String.valueOf(i)+"我就是笑哈哈的测试");
        }
        System.out.println("e");
        JSON.toJSON(menuItemConfigObjects);
    }


    @Test
    public void haha(){
        emptyElse(null,null);
    }
    public static void emptyElse(String var1, Object var2) {
        switch (var1){
            case "lk":
                System.out.println("23");
        }
    }
    @Test
    public void t(){
        String s = "1234";
        String ss =s.substring(2,3);
        String sss =s.substring(2,3);
        System.out.println(sss==ss);
    }
    @Test
    public void errorMessage(){
        List<String> list = Lists.newArrayList();
        List<String> list1 = Lists.newArrayList();
        for (int i = 0; i < 300000; i++) {
            list.add(String.valueOf(i));
        }
        for (int i = 0; i < 200000; i++) {
            list1.add(String.valueOf(i));
        }
        removeAll(list,list1);
        System.out.println(removeAll(list,list1));
    }
    public static List removeAll(List src,List oth) {
        LinkedList result = new LinkedList(src);//大集合用linkedlist
        HashSet othHash = new HashSet(oth);//小集合用hashset
        Iterator iter = result.iterator();//采用Iterator迭代器进行数据的操作
        while (iter.hasNext()) {
            if (othHash.contains(iter.next())) {
                iter.remove();
            }
        }
        return result;
    }

}
