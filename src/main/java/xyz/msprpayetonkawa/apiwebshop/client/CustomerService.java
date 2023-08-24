package xyz.msprpayetonkawa.apiwebshop.client;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Data
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> getCustomerById(final Long id) {
        return customerRepository.findById(id);
    }

    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}

