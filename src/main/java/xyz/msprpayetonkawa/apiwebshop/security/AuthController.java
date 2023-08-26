package xyz.msprpayetonkawa.apiwebshop.security;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.msprpayetonkawa.apiwebshop.client.Customer;
import xyz.msprpayetonkawa.apiwebshop.client.CustomerRepository;
import xyz.msprpayetonkawa.apiwebshop.qrcode.GenerateQRCode;
import xyz.msprpayetonkawa.apiwebshop.security.jwt.JwtUtils;
import xyz.msprpayetonkawa.apiwebshop.security.payload.request.LoginRequest;
import xyz.msprpayetonkawa.apiwebshop.security.payload.request.SignupRequest;
import xyz.msprpayetonkawa.apiwebshop.security.payload.response.AuthToken;
import xyz.msprpayetonkawa.apiwebshop.security.payload.response.MessageResponse;
import xyz.msprpayetonkawa.apiwebshop.security.services.UserDetailsImpl;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    GenerateQRCode generateQRCode;

    @Value("${customer.password}")
    private String defaultPassword;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) throws IOException, WriterException {
        loginRequest.setPassword(defaultPassword);
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateToken(userDetails.getUsername(), userDetails.getEmail());

        generateQRCode.createQRCode(jwtToken, userDetails.getUsername(), userDetails.getEmail());

        return ResponseEntity.ok(new AuthToken(jwtToken));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (customerRepository.findByEmail(signUpRequest.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
        }

        Customer customer = new Customer();
        customer.setUid(UUID.randomUUID().toString());
        customer.setNom(signUpRequest.getLastName());
        customer.setPrenom(signUpRequest.getFirstName());
        customer.setEmail(signUpRequest.getEmail());
        customer.setPassword(encoder.encode(defaultPassword));
        customer.setRole("ROLE_CUSTOMER");
        customerRepository.save(customer);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
