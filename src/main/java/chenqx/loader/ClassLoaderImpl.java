package chenqx.loader;

import lombok.Data;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author chenqx 2019-10-24
 * @instruction
 */
@Data
public class ClassLoaderImpl extends ClassLoader {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        byte[] buffer = null;
        File tradeFile = new File("/Users/chenqx/IdeaProjects/myStudy/target/classes/chenqx/pojo/Book.class");
        try
        {
            FileInputStream fis = new FileInputStream(tradeFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        Class<?> aClass = new ClassLoaderImpl().defineClass("chenqx.pojo.Book", buffer, 0, buffer.length);
        Constructor<?> constructor = aClass.getConstructor(String.class, String.class);
        Object o = constructor.newInstance("123", "321");
        System.out.println(aClass.getName());
        System.out.println(o);
    }
}
