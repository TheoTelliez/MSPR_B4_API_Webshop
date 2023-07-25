package xyz.msprpayetonkawa.apicrm.Order;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.msprpayetonkawa.apicrm.client.Customer;
import xyz.msprpayetonkawa.apicrm.product.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
    @Service
    public class OrderService {

        @Autowired
        private OrderRepository orderRepository;

      /*  public Optional<Customer> getCustomerById(final Long id) {
            return orderRepository.findById(id);
        }*/

        public List<Order> getOrder() {
            return orderRepository.findAll();
        }

        public Product createOrder(Order order) {
            order.setUid(String.valueOf(UUID.randomUUID()));
            return orderRepository.getOrderByCustomer(order.getUid(), order.getDateCreated(),order.getCustomer());
        }

    }

