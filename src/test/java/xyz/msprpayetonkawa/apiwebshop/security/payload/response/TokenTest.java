package xyz.msprpayetonkawa.apiwebshop.security.payload.response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.msprpayetonkawa.apiwebshop.security.payload.response.Token;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class TokenTest {

    private Token token;

    @Before
    public void setUp() {
        token = new Token("TestToken");
    }

    @Test
    public void testGetAndSetToken() {
        String newTokenValue = "NewTestToken";
        token.setToken(newTokenValue);
        assertEquals(newTokenValue, token.getToken());
    }
}
