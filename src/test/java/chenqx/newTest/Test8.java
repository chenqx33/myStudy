package chenqx.newTest;


import chenqx.pojo.Book;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author chenqx 2019-11-26
 * @instruction
 */
public class Test8 {
    @Test
    public void should_(){
        HashMap<Book, Object> objectObjectHashMap = Maps.newHashMapWithExpectedSize(2);
        objectObjectHashMap.put(new Book("2","2"),2);
        objectObjectHashMap.put(new Book("1","2"),1);
        objectObjectHashMap.keySet().forEach(o->o.setAuth("1"));
        Object o = objectObjectHashMap.get(new Book("1", "1"));
        System.out.println(o);
    }

}
