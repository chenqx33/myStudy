package chenqx.aopTest;

import org.junit.Test;

import java.lang.reflect.Proxy;

//https://blog.csdn.net/ZYC88888/article/details/79985231
public class AopTest {
    //JDK动态代理
    @Test
    public void test(){
        BarService service = (BarService) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{BarService.class},
                new LogPrintHandler(new BarServiceImp()));
        String sql = "";
        String json = "";
        service.doSomething("1",7);
    }

    //动态代码字节生成
    @Test
    public void test2(){

    }
    //自定义类加载器
    @Test
    public void test3(){

    }

}
