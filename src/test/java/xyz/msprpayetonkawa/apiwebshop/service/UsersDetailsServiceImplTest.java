package xyz.msprpayetonkawa.apiwebshop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.msprpayetonkawa.apiwebshop.client.Customer;
import xyz.msprpayetonkawa.apiwebshop.client.CustomerRepository;
import xyz.msprpayetonkawa.apiwebshop.product.Product;
import xyz.msprpayetonkawa.apiwebshop.retailer.Retailer;
import xyz.msprpayetonkawa.apiwebshop.security.services.UserDetailsImpl;
import xyz.msprpayetonkawa.apiwebshop.security.services.UserDetailsServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UsersDetailsServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    private final Product product1 = new Product(1L,"uid-key","Name","Description",11.11f,new Retailer(), 1, "image","bleu");
    private final Product product2 = new Product(2L,"other-uid-key","Other-Name","Other-Description",22.22f,new Retailer(), 2, "image","noir");


    private final List<Product> ListProducts1 = Arrays.asList(product1,product2);

    private final Customer customer1 = new Customer(1L,"uid-key","Last Name","First Name","first.last@email.com","Company",true, "", "ROLE_CUSTOMER");

    private final UserDetails expectedUser = UserDetailsImpl.build(customer1);


    @Test
    public void testLoadUserByUsername(){
        String email = "email@company.com";
        Mockito.when(customerRepository.findByEmail(email)).thenReturn(Optional.of(customer1));
        UserDetails user = userDetailsService.loadUserByUsername(email);
        assertEquals(expectedUser,user);
    }

}
