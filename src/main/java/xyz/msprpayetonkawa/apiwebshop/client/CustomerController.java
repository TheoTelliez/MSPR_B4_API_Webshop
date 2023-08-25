package xyz.msprpayetonkawa.apiwebshop.client;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")

@Tag(name = "Customer", description = "Description Customer")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> toReturn = customerService.getCustomers();
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Customer> getCustomerByUid(@PathVariable("uid") String uid) {
        Customer toReturn = customerService.getCustomerById(uid);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }

}
