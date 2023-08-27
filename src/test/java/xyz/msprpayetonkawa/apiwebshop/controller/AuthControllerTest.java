package xyz.msprpayetonkawa.apiwebshop.controller;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.msprpayetonkawa.apiwebshop.WebSecurityConfig;
import xyz.msprpayetonkawa.apiwebshop.client.Customer;
import xyz.msprpayetonkawa.apiwebshop.client.CustomerRepository;
import xyz.msprpayetonkawa.apiwebshop.qrcode.GenerateQRCode;
import xyz.msprpayetonkawa.apiwebshop.security.AuthController;
import xyz.msprpayetonkawa.apiwebshop.security.jwt.JwtUtils;
import xyz.msprpayetonkawa.apiwebshop.security.payload.request.LoginRequest;
import xyz.msprpayetonkawa.apiwebshop.security.payload.request.SignupRequest;
import xyz.msprpayetonkawa.apiwebshop.security.payload.response.AuthToken;
import xyz.msprpayetonkawa.apiwebshop.security.payload.response.MessageResponse;
import xyz.msprpayetonkawa.apiwebshop.security.services.UserDetailsImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext
@Import(WebSecurityConfig.class)
public class AuthControllerTest {
    @InjectMocks
    private AuthController authController;

    @Mock
    private PasswordEncoder encoder;

    @Value("${customer.password}")
    private String defaultPassword;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private JwtUtils jwtUtils;

    @Mock
    private GenerateQRCode generateQRCode;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAuthenticateUser() throws Exception {
        String username = "testUser";
        String jwtToken = "sampleJwtToken";
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);

        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authentication);

        UserDetailsImpl userDetails = Mockito.mock(UserDetailsImpl.class);
        Mockito.when(authentication.getPrincipal()).thenReturn(userDetails);
        Mockito.when(userDetails.getUsername()).thenReturn(username);
        Mockito.when(userDetails.getEmail()).thenReturn("test@example.com");

        Mockito.when(jwtUtils.generateToken(username, userDetails.getEmail())).thenReturn(jwtToken);

        ResponseEntity<AuthToken> response = authController.authenticateUser(loginRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(jwtToken, response.getBody().getToken());

        Mockito.verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        Mockito.verify(jwtUtils).generateToken(username, userDetails.getEmail());
    }

    @Test
    public void testRegisterUser() {

        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setEmail("test@example.com");
        signUpRequest.setLastName("Test lastname");
        signUpRequest.setFirstName("Test firstname");
        signUpRequest.setCompany("Test Company");
        signUpRequest.setProspect(true);

        Mockito.when(customerRepository.findByEmail(signUpRequest.getEmail())).thenReturn(Optional.empty());

        Mockito.when(encoder.encode("encodedPassword")).thenReturn("encodedPassword");

        ResponseEntity<MessageResponse> response = authController.registerUser(signUpRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("User registered successfully!", response.getBody().getMessage());

        Mockito.verify(customerRepository).findByEmail(signUpRequest.getEmail());
        Mockito.verify(customerRepository).save(any(Customer.class));
    }

}
