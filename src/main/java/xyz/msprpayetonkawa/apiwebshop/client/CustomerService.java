package xyz.msprpayetonkawa.apiwebshop.client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;

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

