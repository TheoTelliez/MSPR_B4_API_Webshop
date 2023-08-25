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
import xyz.msprpayetonkawa.apiwebshop.product.Product;
import xyz.msprpayetonkawa.apiwebshop.product.ProductController;
import xyz.msprpayetonkawa.apiwebshop.product.ProductService;
import xyz.msprpayetonkawa.apiwebshop.tools.SpringBeanMockUtil;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Import(WebSecurityConfig.class)
@ActiveProfiles("test")
public class ProductControllerTest {

    @Autowired
    ProductController productController;

    @Test
    public void testGetProducts() {
        ProductService productServiceMock = SpringBeanMockUtil.mockFieldOnBean(productController, ProductService.class);
        doReturn(List.of(new Product())).when(productServiceMock).getProducts();
        Response response = given().when().get("/api/product");

        response.then().statusCode(200);
    }

    @Test
    public void testGetProductbyUid() {
        ProductService productServiceMock = SpringBeanMockUtil.mockFieldOnBean(productController, ProductService.class);
        doReturn(new Product()).when(productServiceMock).getProduct("uid");
        Response response = given().when().pathParams("uid", "uid").get("/api/product/{uid}");
        response.then().statusCode(200);
    }

}
