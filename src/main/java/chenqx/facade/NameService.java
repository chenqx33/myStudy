package chenqx.facade;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-20 11:29
 **/
@Service
public class NameService implements INameService {
    @Override
    public String getName() {
        return "name";
    }
}
