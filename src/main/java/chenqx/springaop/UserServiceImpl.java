package chenqx.springaop;

import org.springframework.stereotype.Service;

/**
 * @author chenqx 2019-11-25
 * @instruction
 */
@Service
public class UserServiceImpl implements HelloInterface {
    @Override
    public String sayHello() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("userHello");
        return "userHello";

    }
}
