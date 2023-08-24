package xyz.msprpayetonkawa.apiwebshop.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.msprpayetonkawa.apiwebshop.client.Customer;
import xyz.msprpayetonkawa.apiwebshop.order.Order;
import xyz.msprpayetonkawa.apiwebshop.order.OrderRepository;
import xyz.msprpayetonkawa.apiwebshop.order.OrderService;
import xyz.msprpayetonkawa.apiwebshop.relations.OrderProduct;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Before
    public void setUp(){
        Order order1 = new Order();
        order1.setId(1L);
        order1.setUid("order-uid-1");
        order1.setDateCreated(new Date());
        order1.setProductList(Arrays.asList(new OrderProduct()));
        order1.setCustomer(new Customer());

        Order order2 = new Order();
        order2.setId(2L);
        order2.setUid("order-uid-2");
        order2.setDateCreated(new Date());
        order2.setProductList(Arrays.asList(new OrderProduct()));
        order2.setCustomer(new Customer());

        List<Order> orders = Arrays.asList(order1, order2);

        Mockito.when(orderRepository.findAll()).thenReturn(orders);
    }

    @Test
    public void testGetOrder(){
        List<Order> result = orderService.getOrder();
        assertEquals(2, result.size());
    }

}
