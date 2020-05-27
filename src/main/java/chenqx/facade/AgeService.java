package chenqx.facade;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-20 11:29
 **/
@Service
public class AgeService implements IAgeService {
    @Override
    public String sendAge() {
        System.out.println("123");
        return "true";
    }
}
