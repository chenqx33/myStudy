package chenqx.springaop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenqx 2019-11-25
 * @instruction
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        HelloInterface userService = context.getBean(HelloInterface.class);

        userService.sayHello();

        context.close();

    }
}
