package xyz.msprpayetonkawa.apiwebshop.security.payload.request;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.msprpayetonkawa.apiwebshop.security.payload.request.LoginRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LoginRequestTest {

	private LoginRequest loginRequest;

	@Before
	public void setUp() {
		loginRequest = new LoginRequest();
	}

	@Test
	public void testSetAndGetUsername() {
		String username = "testUser";
		loginRequest.setUsername(username);
		assertEquals(username, loginRequest.getUsername());
	}

	@Test
	public void testSetAndGetPassword() {
		String password = "testPassword";
		loginRequest.setPassword(password);
		assertEquals(password, loginRequest.getPassword());
	}

}
