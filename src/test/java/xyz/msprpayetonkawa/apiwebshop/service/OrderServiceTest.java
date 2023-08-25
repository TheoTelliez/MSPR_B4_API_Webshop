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
import xyz.msprpayetonkawa.apiwebshop.client.CustomerRepository;
import xyz.msprpayetonkawa.apiwebshop.order.Order;
import xyz.msprpayetonkawa.apiwebshop.order.OrderRepository;
import xyz.msprpayetonkawa.apiwebshop.order.OrderService;
import xyz.msprpayetonkawa.apiwebshop.product.Product;
import xyz.msprpayetonkawa.apiwebshop.product.ProductRepository;
import xyz.msprpayetonkawa.apiwebshop.relations.OrderProduct;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private OrderService orderService;

    @Before
    public void setUp(){
        Order order1 = new Order();
        order1.setId(1L);
        order1.setUid("order-uid-1");
        order1.setDateCreated(LocalDateTime.now());
        order1.setProductList(Arrays.asList(new OrderProduct()));
        order1.setCustomer(new Customer());

        Order order2 = new Order();
        order2.setId(2L);
        order2.setUid("order-uid-2");
        order2.setDateCreated(LocalDateTime.now());
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

    @Test
    public void testSaveOrder() {
        Order orderToAdd = new Order();
        orderToAdd.setId(3L);
        orderToAdd.setUid("added-order-uid-key");
        orderToAdd.setDateCreated(LocalDateTime.now());

        Product sampleProduct = new Product();
        sampleProduct.setUid("sample-product-uid");

        OrderProduct sampleOrderProduct = new OrderProduct();
        sampleOrderProduct.setProduct(sampleProduct);

        orderToAdd.setProductList(Arrays.asList(sampleOrderProduct));
        orderToAdd.setCustomer(new Customer(2L,"other-uid-key","Other Last Name","Other First Name","otherfirst.otherlast@email.com","Other Company",false));

        Mockito.when(orderRepository.save(any(Order.class))).thenReturn(orderToAdd);
        Mockito.when(customerRepository.findByUid(anyString())).thenReturn(orderToAdd.getCustomer());
        Mockito.when(productRepository.findByUid(sampleProduct.getUid())).thenReturn(sampleProduct);


        Order result = orderService.saveOrders(orderToAdd);

        assertNotNull(result);
        assertEquals(orderToAdd.getUid(), result.getUid());
        assertEquals(orderToAdd.getDateCreated(), result.getDateCreated());
        assertEquals(orderToAdd.getCustomer(), result.getCustomer());
        assertEquals(orderToAdd.getProductList().size(), result.getProductList().size());

        assertNotNull(result.getUid());

        assertNotNull(result.getDateCreated());
    }

}
