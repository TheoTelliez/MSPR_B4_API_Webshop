package xyz.msprpayetonkawa.apiwebshop.controller;

import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.msprpayetonkawa.apiwebshop.WebSecurityConfig;
import xyz.msprpayetonkawa.apiwebshop.client.Customer;
import xyz.msprpayetonkawa.apiwebshop.client.CustomerController;
import xyz.msprpayetonkawa.apiwebshop.client.CustomerService;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
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
        when(customerService.getCustomers()).thenReturn(List.of(new Customer()));

        Response response = given().when().get("/api/customer");
        response.then().statusCode(200);
    }

    @Test
    public void testAddCustomer() {
        Customer mockCustomer = new Customer();
        when(customerService.saveCustomer(any(Customer.class))).thenReturn(mockCustomer);

        Response response = given()
                .contentType("application/json")
                .body(mockCustomer)
                .when()
                .post("/api/customer");
        response.then().statusCode(200);

    }

    @Test
    public void testGetCustomerByID() {
        String mockUid = "12345";
        Customer mockCustomer = new Customer();
        when(customerService.getCustomerById(mockUid)).thenReturn(mockCustomer);

        Response response = given().when().get("/api/customer/" + mockUid);
        response.then().statusCode(200);

    }
}
