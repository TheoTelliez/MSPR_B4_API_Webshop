package xyz.msprpayetonkawa.apiwebshop.security.payload.response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class UserInfoResponseTest {

    private UserInfoResponse userInfoResponse;

    @Before
    public void setUp() {
        List<String> roles = Arrays.asList("ROLE_USER", "ROLE_ADMIN");
        userInfoResponse = new UserInfoResponse(1L, "testUser", "testUser@example.com", roles);
    }

    @Test
    public void testGetAndSetId() {
        Long newId = 2L;
        userInfoResponse.setId(newId);
        assertEquals(newId, userInfoResponse.getId());
    }

    @Test
    public void testGetAndSetUsername() {
        String newUsername = "newTestUser";
        userInfoResponse.setUsername(newUsername);
        assertEquals(newUsername, userInfoResponse.getUsername());
    }

    @Test
    public void testGetAndSetEmail() {
        String newEmail = "newTestUser@example.com";
        userInfoResponse.setEmail(newEmail);
        assertEquals(newEmail, userInfoResponse.getEmail());
    }

    @Test
    public void testGetRoles() {
        List<String> roles = Arrays.asList("ROLE_USER", "ROLE_ADMIN");
        assertEquals(roles, userInfoResponse.getRoles());
    }
}
