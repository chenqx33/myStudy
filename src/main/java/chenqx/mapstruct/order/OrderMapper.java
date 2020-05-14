package chenqx.mapstruct.order;

import org.mapstruct.Mapper;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-01 18:47
 **/
@Mapper
public interface OrderMapper {
    OrderQueryParam entity2queryParam(Order order);
}
