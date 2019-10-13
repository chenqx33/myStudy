package chenqx.provider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author chenqx 2019-09-30
 * @instruction
 */
public class Test {
    @org.junit.Test
    public void should_redis(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        Map<String, Provider> beansOfType = context.getBeansOfType(Provider.class);
        System.out.println("1");
    }
}
