//package xyz.msprpayetonkawa.apiwebshop.security;
//
//import com.google.zxing.WriterException;
//import io.restassured.response.Response;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import xyz.msprpayetonkawa.apiwebshop.WebSecurityConfig;
//import xyz.msprpayetonkawa.apiwebshop.security.payload.request.LoginRequest;
//import xyz.msprpayetonkawa.apiwebshop.security.payload.request.SignupRequest;
//
//import java.io.IOException;
//
//import static io.restassured.RestAssured.given;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@DirtiesContext
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@Import(WebSecurityConfig.class)
//@ActiveProfiles("test")
//public class AuthControllerTest {

//    @Autowired
//    AuthControllerTest authController;
//
//    @Test
//    public void testAuthenticateUser() throws IOException, WriterException {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("testuser");
//
//        Response response = given()
//                .contentType("application/json")
//                .body(loginRequest)
//                .when()
//                .post("/api/auth/signin");
//
//        response.then()
//                .statusCode(200);
//    }
//
//    @Test
//    public void testRegisterUser() {
//        SignupRequest signupRequest = new SignupRequest();
//        signupRequest.setFirstName("Test");
//        signupRequest.setLastName("User");
//        signupRequest.setEmail("testuser@example.com");
//
//        Response response = given()
//                .contentType("application/json")
//                .body(signupRequest)
//                .when()
//                .post("/api/auth/signup");
//
//        response.then()
//                .statusCode(200);
//    }

//}
