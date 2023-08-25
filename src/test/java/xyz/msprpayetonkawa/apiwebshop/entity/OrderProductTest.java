package xyz.msprpayetonkawa.apiwebshop.entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.msprpayetonkawa.apiwebshop.order.Order;
import xyz.msprpayetonkawa.apiwebshop.product.Product;
import xyz.msprpayetonkawa.apiwebshop.relations.OrderProduct;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class OrderProductTest {

    private OrderProduct orderProduct;
    private Order order;
    private Product product;

    @Before
    public void setUp() {
        order = new Order();
        product = new Product();
        orderProduct = new OrderProduct(order, product, 5);
    }

    @Test
    public void testOrderProduct() {
        assertEquals(order, orderProduct.getOrder());
        assertEquals(product, orderProduct.getProduct());
        assertEquals(5, orderProduct.getQuantityOrdered());
    }
}
