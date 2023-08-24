package xyz.msprpayetonkawa.apiwebshop.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import xyz.msprpayetonkawa.apiwebshop.product.Product;
import xyz.msprpayetonkawa.apiwebshop.product.ProductController;
import xyz.msprpayetonkawa.apiwebshop.product.ProductService;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProducts() throws Exception {
        when(productService.getProducts()).thenReturn(List.of(new Product()));

        mockMvc.perform(get("/api/product"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetProductbyUid() throws Exception {
        String mockUid = "12345";
        Product mockProduct = new Product();
        when(productService.getProduct(mockUid)).thenReturn(mockProduct);

        mockMvc.perform(get("/api/product" + mockUid))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
