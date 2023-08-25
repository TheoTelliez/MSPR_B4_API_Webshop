package xyz.msprpayetonkawa.apiwebshop.controller;

import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.msprpayetonkawa.apiwebshop.WebSecurityConfig;
import xyz.msprpayetonkawa.apiwebshop.order.Order;
import xyz.msprpayetonkawa.apiwebshop.order.OrderController;
import xyz.msprpayetonkawa.apiwebshop.order.OrderService;
import xyz.msprpayetonkawa.apiwebshop.tools.SpringBeanMockUtil;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Import(WebSecurityConfig.class)
@ActiveProfiles("test")
public class OrderControllerTest {

    @InjectMocks
    OrderController orderController;

    @Mock
    OrderService orderService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetOrderByCustomer() {
        doReturn(List.of(new Order())).when(orderService).getOrder();

        Response response = given().when().get("/api/order");
        response.then().statusCode(200);

    }

    @Test
    public void testAddOrder() {
        Order order = new Order();
        OrderService orderServiceMock = SpringBeanMockUtil.mockFieldOnBean(orderController, OrderService.class);
        doReturn(new Order()).when(orderServiceMock).saveOrders(Mockito.any(Order.class));
        Response response = given().contentType("application/json").when().body(order).post("/api/order");
        response.then().statusCode(201);
    }

}