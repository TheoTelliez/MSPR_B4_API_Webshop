package xyz.msprpayetonkawa.apiwebshop.product;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")

@Tag(name = "Product", description = "Description Product")

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> toReturn = productService.getProducts();
        return ResponseEntity.ok(toReturn);
    }

    @GetMapping("/{uid}")
    public Product getProductByUid(@PathVariable("uid") String uid) {
        return productService.getProduct(uid);
    }

}