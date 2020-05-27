package chenqx.facade;

import lombok.experimental.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-20 11:26
 **/
@Service
public class ServiceFacade implements IAgeService, INameService {
    @Delegate
    @Autowired
    private IAgeService ageService;
    @Delegate
    @Autowired
    private INameService nameService;

}
