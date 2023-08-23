package xyz.msprpayetonkawa.apiwebshop.client;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")

@Tag(name = "Customer", description = "Description Customer")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public Iterable<Customer> getAllProducts() {
       return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getProductById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
