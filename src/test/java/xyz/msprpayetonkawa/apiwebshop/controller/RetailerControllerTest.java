package xyz.msprpayetonkawa.apiwebshop.controller;

import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.msprpayetonkawa.apiwebshop.WebSecurityConfig;
import xyz.msprpayetonkawa.apiwebshop.retailer.Retailer;
import xyz.msprpayetonkawa.apiwebshop.retailer.RetailerController;
import xyz.msprpayetonkawa.apiwebshop.retailer.RetailerService;
import xyz.msprpayetonkawa.apiwebshop.tools.SpringBeanMockUtil;

import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext
@Import(WebSecurityConfig.class)
public class RetailerControllerTest {

    @Autowired
    RetailerController retailerController;

    @Test
    public void testGetRetailers() {
        RetailerService retailerServiceMock = SpringBeanMockUtil.mockFieldOnBean(retailerController, RetailerService.class);
        doReturn(List.of(new Retailer())).when(retailerServiceMock).getRetailers();
        Response response = given().when().get("/api/retailer");

        response.then().statusCode(200);
    }

    @Test
    public void testGetRetailerByUid() {
        RetailerService retailerServiceMock = SpringBeanMockUtil.mockFieldOnBean(retailerController, RetailerService.class);
        doReturn(new Retailer()).when(retailerServiceMock).getRetailerByUid("uid");
        Response response = given().when().pathParams("uid", "uid").get("/api/retailer/{uid}");
        response.then().statusCode(200);
    }
}
