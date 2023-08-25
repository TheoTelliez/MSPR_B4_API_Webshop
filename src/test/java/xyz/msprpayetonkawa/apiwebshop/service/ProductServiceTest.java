package xyz.msprpayetonkawa.apiwebshop.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.msprpayetonkawa.apiwebshop.product.Product;
import xyz.msprpayetonkawa.apiwebshop.product.ProductRepository;
import xyz.msprpayetonkawa.apiwebshop.product.ProductService;
import xyz.msprpayetonkawa.apiwebshop.retailer.Retailer;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    private final Retailer mockRetailer = new Retailer();

    private final Product product1 = new Product(1L, "uid-key", "Name", "Description", 11.11f, mockRetailer, 1, "image1.jpg", "noir");
    private final Product product2 = new Product(2L, "other-uid-key", "Other-Name", "Other-Description", 22.22f, mockRetailer, 2, "image2.jpg", "noir");
    private final List<Product> products = Arrays.asList(product1, product2);

    @InjectMocks
    private ProductService productService;

    @Before
    public void setUp(){
    }

    @Test
    public void testFindAllProducts(){
        Mockito.when(productRepository.findAll()).thenReturn(products);
        List<Product> result = productService.getProducts();
        assertEquals(products,result);
    }

    @Test
    public void testEqualsAndHash(){
        Product product = new Product(1L, "uid-key", "Name", "Description", 11.11f, mockRetailer, 1, "image1.jpg", "noir");
        Product productCopy = new Product(1L, "uid-key", "Name", "Description", 11.11f, mockRetailer, 1, "image1.jpg", "noir");
        assertEquals(product,productCopy);
        assertEquals(product.hashCode(), productCopy.hashCode());
        assertEquals(product.toString(), productCopy.toString());
    }

    @Test
    public void testNotEqualsAndNotHash(){
        Product product = new Product(1L, "uid-key", "Name", "Description", 11.11f, mockRetailer, 1, "image1.jpg", "noir");
        Product otherProduct = new Product(2L, "other-uid-key", "Other-Name", "Other-Description", 22.22f, mockRetailer, 2, "image2.jpg", "noir");
        assertNotEquals(product,otherProduct);
        assertNotEquals(product.hashCode(), otherProduct.hashCode());
        assertNotEquals(product.toString(), otherProduct.toString());
    }

    @Test
    public void testFindProductByUidThatExists(){
        String uid = "uid-key";
        Mockito.when(productRepository.findByUid(uid)).thenReturn(product1);
        Product result = productService.getProduct(uid);
        assertEquals(product1,result);
    }

    @Test
    public void testFindProductByUidThatDoesNotExists(){
        String uid = "no-uid-key";
        Mockito.when(productRepository.findByUid(uid)).thenReturn(null);
        Product result = productService.getProduct(uid);
        assertNull(result);
    }
}
