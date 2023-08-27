package xyz.msprpayetonkawa.apiwebshop.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.msprpayetonkawa.apiwebshop.product.Product;
import xyz.msprpayetonkawa.apiwebshop.retailer.Retailer;
import xyz.msprpayetonkawa.apiwebshop.retailer.RetailerRepository;
import xyz.msprpayetonkawa.apiwebshop.retailer.RetailerService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RetailerServiceTest {

    @Mock
    private RetailerRepository retailerRepository;

    private final Product product1 = new Product(1L,"uid-key","Name","Description",11.11f,new Retailer(), 1, "image","bleu");
    private final Product product2 = new Product(2L,"other-uid-key","Other-Name","Other-Description",22.22f,new Retailer(), 2, "image","noir");

    private final Product product3 = new Product("New-Name","New-Description",33.33f,3);

    private final List<Product> ListProducts1 = Arrays.asList(product1,product3);

    private final Retailer retailer1 = new Retailer(1L,"retailer-uid-key","Name","email@company.com","pass","Admin",ListProducts1);
    private final List<Product> ListProducts2 = Arrays.asList(product1, product2);

    private final Retailer retailer2 = new Retailer(2L,"other-retailer-uid-key","Other Name","email@othercompany.com","otherpass","Admin",ListProducts2);

    private final List<Retailer> retailers = Arrays.asList(retailer1,retailer2);

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private RetailerService retailerService;

    @Before
    public void setUp(){
        Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenReturn("encodedDefaultPassword");
    }

    @Test
    public void testFindAllRetailers(){
        Mockito.when(retailerRepository.findAll()).thenReturn(retailers);
        List<Retailer> result = retailerService.getRetailers();
        assertEquals(retailers,result);
    }

    @Test
    public void testFindRetailerByUidThatExists(){
        String uid = "retailer-uid-key";
        Mockito.when(retailerRepository.findByUid(uid)).thenReturn(retailer1);
        Retailer result = retailerService.getRetailerByUid(uid);
        assertEquals(retailer1,result);
    }

    @Test
    public void testFindRetailerByUidThatDoesNotExists(){
        String uid = "no-uid-key";
        Mockito.when(retailerRepository.findByUid(uid)).thenReturn(null);
        Retailer result = retailerService.getRetailerByUid(uid);
        assertNull(result);
    }


}
