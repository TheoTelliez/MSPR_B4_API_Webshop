package xyz.msprpayetonkawa.apiwebshop.entity;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.msprpayetonkawa.apiwebshop.WebSecurityConfig;
import xyz.msprpayetonkawa.apiwebshop.security.jwt.AuthTokenFilter;
import xyz.msprpayetonkawa.apiwebshop.security.jwt.JwtUtils;
import xyz.msprpayetonkawa.apiwebshop.security.services.UserDetailsServiceImpl;

import java.io.IOException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@Import(WebSecurityConfig.class)
@ExtendWith(MockitoExtension.class)
public class AuthTokenFilterTest {

    @InjectMocks
    private AuthTokenFilter authTokenFilter;
    @Mock
    private JwtUtils jwtUtils;

    @Mock
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    @Mock
    private UserDetails userDetails;

    @Mock
    private UsernamePasswordAuthenticationToken authenticationToken;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDoFilterInternal_WithValidJwt() throws ServletException, IOException {
        // Mocking behavior of JwtUtils and userDetailsService
        Mockito.when(request.getRequestURI()).thenReturn("/api/some-endpoint");
        Mockito.when(jwtUtils.getJWTFromRequest(request)).thenReturn("validJwt");
        Mockito.when(jwtUtils.validateJwtToken("validJwt")).thenReturn(true);
        Mockito.when(jwtUtils.getUserNameFromJwtToken("validJwt")).thenReturn("username");

        // Create a UserDetails object
        UserDetails userDetails = new User("username", "password", Collections.emptyList());

        // Create an expected authentication token
        Authentication expectedAuthentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        Mockito.when(userDetailsService.loadUserByUsername("username")).thenReturn(userDetails);
        Mockito.when(authenticationToken.getDetails()).thenReturn(null);

        // Execute the filter
        authTokenFilter.doFilter(request, response, filterChain);

        // Get the actual authentication from SecurityContextHolder
        Authentication actualAuthentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if authentication was set in the SecurityContextHolder
        assertEquals(expectedAuthentication.getPrincipal(), actualAuthentication.getPrincipal());
        assertEquals(expectedAuthentication.getAuthorities(), actualAuthentication.getAuthorities());
        assertEquals(expectedAuthentication.isAuthenticated(), actualAuthentication.isAuthenticated());

        // Verify that filterChain was called
        Mockito.verify(filterChain, times(1)).doFilter(request, response);
    }

    @Test
    public void testDoFilterInternal_WithAuth() throws ServletException, IOException {
        // Mocking behavior of HttpServletRequest
        Mockito.when(request.getRequestURI()).thenReturn("/api/auth/some-endpoint");

        // Execute the filter
        authTokenFilter.doFilter(request, response, filterChain);

        // Check if authentication was never set in the SecurityContextHolder
        assertNull(SecurityContextHolder.getContext().getAuthentication());

        // Verify that filterChain was called
        Mockito.verify(filterChain, times(1)).doFilter(request, response);
    }

    @Test
    public void testDoFilterInternal_WithDocs() throws ServletException, IOException {
        // Mocking behavior of HttpServletRequest
        Mockito.when(request.getRequestURI()).thenReturn("/api/docs/some-endpoint");

        // Execute the filter
        authTokenFilter.doFilter(request, response, filterChain);

        // Check if authentication was never set in the SecurityContextHolder
        assertNull(SecurityContextHolder.getContext().getAuthentication());

        // Verify that filterChain was called
        Mockito.verify(filterChain, times(1)).doFilter(request, response);
    }

}


