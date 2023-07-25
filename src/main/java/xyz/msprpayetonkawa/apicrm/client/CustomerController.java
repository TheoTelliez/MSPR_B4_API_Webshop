package xyz.msprpayetonkawa.apicrm.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
@RestController
@RequestMapping("/customer")
public class ClientController {
    private final ClientRepository clientRepository;
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

        @PutMapping
        Mono<Clients> createOrUpdateMovie(@RequestBody Clients newClient) {
            return clientRepository.save(newClient);
        }
    }
    //method implementations with walkthroughs below
}


*/
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public Iterable<Customer> getAllProducts() {
       return customerService.getCustomers();
    }

    @PostMapping
    public Customer addClient(@RequestBody Customer clients) {
        return customerService.saveCustomer(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getProductById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
