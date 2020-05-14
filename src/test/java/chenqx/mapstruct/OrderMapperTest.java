package chenqx.mapstruct;

import chenqx.mapstruct.order.Order;
import chenqx.mapstruct.order.OrderMapper;
import chenqx.mapstruct.order.OrderQueryParam;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-01 18:48
 **/
public class OrderMapperTest {
    @Test
    public void entity2queryParam() {
        Order order = new Order();
        order.setId(12345L);
        order.setOrderSn("orderSn");
        order.setOrderType(0);
        order.setReceiverKeyword("keyword");
        order.setSourceType(1);
        order.setStatus(2);
        OrderMapper mapper = Mappers.getMapper(OrderMapper.class);
        OrderQueryParam orderQueryParam = mapper.entity2queryParam(order);
        assertEquals(orderQueryParam.getOrderSn(), order.getOrderSn());
        assertEquals(orderQueryParam.getOrderType(), order.getOrderType());
        assertEquals(orderQueryParam.getReceiverKeyword(), order.getReceiverKeyword());
        assertEquals(orderQueryParam.getSourceType(), order.getSourceType());
        assertEquals(orderQueryParam.getStatus(), order.getStatus());
    }

}