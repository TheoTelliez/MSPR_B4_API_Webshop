package xyz.msprpayetonkawa.apiwebshop.order;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")

@Tag(name = "Order", description = "Description Order")

public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public Iterable<Order> getOrderByCustomer() {
        return orderService.getOrder();
    }

}
