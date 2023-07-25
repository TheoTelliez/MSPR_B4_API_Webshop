package xyz.msprpayetonkawa.apicrm.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.msprpayetonkawa.apicrm.client.Customer;
import xyz.msprpayetonkawa.apicrm.product.Product;


@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping
    public Iterable<Order> getOrderByCustomer() {
       return orderService.getOrder();
    }

    @PostMapping()
    public Product addOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }
    /*
    @PostMapping
    public Customer addOrder(@RequestBody Customer clients) {
        return customerService.saveCustomer(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getProductById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
*/

}
