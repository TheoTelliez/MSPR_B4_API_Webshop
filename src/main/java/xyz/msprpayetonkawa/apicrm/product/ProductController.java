package xyz.msprpayetonkawa.apicrm.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Read - Get all employees
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping()
    public Iterable<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{uid}")
    public Optional<Product> getProductByUid(@PathVariable("uid") String uid) {
        return productService.getProduct(uid);
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product){
        return productService.saveProducts(product);
    }

}