package xyz.msprpayetonkawa.apiwebshop.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.msprpayetonkawa.apiwebshop.WebSecurityConfig;
import xyz.msprpayetonkawa.apiwebshop.security.payload.request.LoginRequest;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@Import(WebSecurityConfig.class)
public class LoginRequestTest {

    @Test
    public void testSetAndGetUsername() {
        LoginRequest loginRequest = new LoginRequest();
        String username = "testUser";
        loginRequest.setUsername(username);
        assertEquals(username, loginRequest.getUsername());
    }

    @Test
    public void testSetAndGetPassword() {
        LoginRequest loginRequest = new LoginRequest();
        String password = "testPassword";
        loginRequest.setPassword(password);
        assertEquals(password, loginRequest.getPassword());
    }

}


