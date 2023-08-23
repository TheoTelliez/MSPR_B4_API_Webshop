package xyz.msprpayetonkawa.apiwebshop.order;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

}

