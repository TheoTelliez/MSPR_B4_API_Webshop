package xyz.msprpayetonkawa.apiwebshop.security.payload.request;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.msprpayetonkawa.apiwebshop.security.payload.request.SignupRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SignupRequestTest {

    private SignupRequest signupRequest;

    @Before
    public void setUp() {
        signupRequest = new SignupRequest();
    }

    @Test
    public void testSetAndGetEmail() {
        String email = "test@example.com";
        signupRequest.setEmail(email);
        assertEquals(email, signupRequest.getEmail());
    }

    @Test
    public void testSetAndGetLastName() {
        String lastName = "Test lastName";
        signupRequest.setLastName(lastName);
        assertEquals(lastName, signupRequest.getLastName());
    }

    @Test
    public void testSetAndGetFirstName() {
        String firstName = "Test firstName";
        signupRequest.setFirstName(firstName);
        assertEquals(firstName, signupRequest.getFirstName());
    }

    @Test
    public void testSetAndGetCompany() {
        String company = "Test Company";
        signupRequest.setCompany(company);
        assertEquals(company, signupRequest.getCompany());
    }

    @Test
    public void testSetAndGetProspect() {
        String prospect = "Test Prospect";
        signupRequest.setProspect(prospect);
        assertEquals(prospect, signupRequest.getProspect());
    }
}
