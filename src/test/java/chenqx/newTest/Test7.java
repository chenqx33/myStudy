package chenqx.newTest;

import chenqx.pojo.Book;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


/**
 * @author chenqx 2019-10-23
 * @instruction
 */
public class Test7 {
    @Test
    public void should_lambda() {
//        //编译通过
//        Stream.of("a", "b", "c").forEach(str -> {
//            throw new RuntimeException();
//        });

        //编译失败
//        Stream.of("a", "b", "c").forEach(str -> {
//            throw new IOException();
//        });


        //编译通过
        Stream.of("a", "b", "c").forEach(str -> {
            doThrow(new FileNotFoundException());
        });
    }

    //编写一个泛型方法对异常进行包装
    static <E extends Exception> void doThrow(Exception e) throws E {
        throw (E) e;
    }

    @Test
    public void should_constructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Book> constructor = Book.class.getConstructor(String.class, String.class);
        Book book = constructor.newInstance("123", "321");
        System.out.println(book);
    }

    @Test
    public void should_hh() {
        byte[] buffer = null;
        File tradeFile = new File("/Users/chenqx/IdeaProjects/myStudy/src/main/resources/chenqx/pojo/Book.class");
        try {
            FileInputStream fis = new FileInputStream(tradeFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Class<?> aClass = new ClassLoaderImpl().defineClass("chenqx.pojo.Book", buffer, 0, buffer.length);

    }


    @Test
    public void should_bigdecimal() {
        System.out.println(new Double("0.0") == 0);
        System.out.println(Integer.valueOf(1).equals(1));
        System.out.println(new BigDecimal("1.0").equals(BigDecimal.valueOf(1.0)));
    }

    @Test
    public void thread() throws InterruptedException {
        AtomicInteger order = new AtomicInteger(0);
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                order.incrementAndGet();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                System.out.println(order.get());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(10000);
    }

    @Test
    public void should_getordefault() {
        Map<String, String> map = Maps.newHashMap();
        map.put("123", null);
        System.out.println(map.getOrDefault("123", "321"));
        System.out.println(map.getOrDefault("1234", "321"));
        System.out.println(map.merge("123", "321", (x, y) -> null));
        System.out.println(map);
    }
    @Test
    public void should_double(){
        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
        Object o = objectObjectHashMap.computeIfAbsent(1,oo-> Lists.newArrayList());
        System.out.println(objectObjectHashMap);
        System.out.println(o);
    }
}
