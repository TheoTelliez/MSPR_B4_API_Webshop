package xyz.msprpayetonkawa.apiwebshop.controller;

import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.msprpayetonkawa.apiwebshop.WebSecurityConfig;
import xyz.msprpayetonkawa.apiwebshop.client.Customer;
import xyz.msprpayetonkawa.apiwebshop.client.CustomerController;
import xyz.msprpayetonkawa.apiwebshop.client.CustomerService;
import xyz.msprpayetonkawa.apiwebshop.tools.SpringBeanMockUtil;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@Import(WebSecurityConfig.class)
public class CustomerControllerTest {

    @InjectMocks
    CustomerController customerController;

    @Mock
    CustomerService customerService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCustomer() {
        CustomerService customerServiceMock = SpringBeanMockUtil.mockFieldOnBean(customerController, CustomerService.class);
        doReturn(List.of(new Customer())).when(customerServiceMock).getCustomers();

        Response response = given().when().get("/api/customer");
        response.then().statusCode(200);
    }

    @Test
    public void testGetCustomerByID() {
        CustomerService customerServiceMock = SpringBeanMockUtil.mockFieldOnBean(customerController, CustomerService.class);
        doReturn(new Customer()).when(customerServiceMock).getCustomerById(Mockito.any(String.class));
        String mockUid = "12345";

        Response response = given().when().get("/api/customer/" + mockUid);
        response.then().statusCode(200);

    }
}
