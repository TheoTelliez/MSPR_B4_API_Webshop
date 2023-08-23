package xyz.msprpayetonkawa.apicrm.product;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
    public Optional<Product> getProductByUid(@PathVariable("uid") String uid) {
        return productService.getProduct(uid);
    }

}