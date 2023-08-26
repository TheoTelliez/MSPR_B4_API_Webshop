package xyz.msprpayetonkawa.apiwebshop.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.msprpayetonkawa.apiwebshop.WebSecurityConfig;
import xyz.msprpayetonkawa.apiwebshop.product.Product;
import xyz.msprpayetonkawa.apiwebshop.retailer.Retailer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@Import(WebSecurityConfig.class)
public class ProductTest {

    @Test
    public void testEqualsAndHash(){
        Product product = new Product(1L,"uid-key","Name","Description",11.11f, new Retailer(), 0, "image","bleu");
        Product productCopy = new Product(1L,"uid-key","Name","Description",11.11f, new Retailer(), 0, "image","bleu");
        assertEquals(product,productCopy);
        assertEquals(product.hashCode(), productCopy.hashCode());
        assertEquals(product.toString(), productCopy.toString());
    }

    @Test
    public void testNotEqualsAndNotHash(){
        Product product = new Product(1L,"uid-key","Name","Description",11.11f, new Retailer(), 0, "image","bleu");
        Product otherProduct = new Product(2L,"other-uid-key","Other-Name","Other-Description",22.22f, new Retailer(), 0, "image","noir");
        assertNotEquals(product,otherProduct);
        assertNotEquals(product.hashCode(), otherProduct.hashCode());
        assertNotEquals(product.toString(), otherProduct.toString());
    }
}
