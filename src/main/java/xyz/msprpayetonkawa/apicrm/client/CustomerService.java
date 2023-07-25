package xyz.msprpayetonkawa.apicrm.client;

import java.util.Optional;
import java.util.UUID;

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

        public Customer saveCustomer(Customer customer) {
            customer.setUid(String.valueOf(UUID.randomUUID()));
            return customerRepository.save(customer);
        }

    }

