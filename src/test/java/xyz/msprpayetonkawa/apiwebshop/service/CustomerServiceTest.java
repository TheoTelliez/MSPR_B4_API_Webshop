package xyz.msprpayetonkawa.apiwebshop.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.msprpayetonkawa.apiwebshop.client.Customer;
import xyz.msprpayetonkawa.apiwebshop.client.CustomerRepository;
import xyz.msprpayetonkawa.apiwebshop.client.CustomerService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setUp(){
        Customer customer1 = new Customer(1L,"uid-key","Last Name","First Name","first.last@email.com","Company",true);
        Customer customer2 = new Customer(2L,"other-uid-key","Other Last Name","Other First Name","otherfirst.otherlast@email.com","Other Company",false);
        List<Customer> customers = Arrays.asList(customer1, customer2);


        Mockito.when(customerRepository.findAll()).thenReturn(customers);
        Mockito.when(customerRepository.findByUid("uid-key")).thenReturn(customer1);
        Mockito.when(customerRepository.findByUid("no-uid-key")).thenReturn(null);
    }

    @Test
    public void testEqualsAndHash(){
        Customer customer = new Customer(1L,"uid-key","Last Name","First Name","first.last@email.com","Company",true);
        Customer customerCopy = new Customer(1L,"uid-key","Last Name","First Name","first.last@email.com","Company",true);
        assertEquals(customer,customerCopy);
        assertEquals(customer.hashCode(), customerCopy.hashCode());
    }

    @Test
    public void testNotEqualsAndNotHash(){
        Customer customer = new Customer(1L,"uid-key","Last Name","First Name","first.last@email.com","Company",true);
        Customer otherCustomer = new Customer(2L,"other-uid-key","Other Last Name","Other First Name","otherfirst.otherlast@email.com","Other Company",false);
        assertNotEquals(customer,otherCustomer);
        assertNotEquals(customer.hashCode(), otherCustomer.hashCode());
    }

    @Test
    public void testFindAllCustomers(){
        List<Customer> result = customerService.getCustomers();
        assertEquals(2,result.size());
    }

    @Test
    public void testFindCustomerByUidThatExists(){
        String uid = "uid-key";
        Customer result = customerService.getCustomerById(uid);
        assertEquals(1L,result.getId());
    }

    @Test
    public void testFindCustomerByUidThatDoesNotExists(){
        String uid = "no-uid-key";
        Customer result = customerService.getCustomerById(uid);
        assertNull(result);
    }

    @Test
    public void testSaveCustomer() {
        Customer customer3 = new Customer(3L,"new-uid-key","New Last Name","New First Name","newfirst.newlast@email.com","Other Company",false);

        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(customer3);

        Customer result = customerService.saveCustomer(customer3);

        assertNotNull(result);
        assertEquals(customer3,result);
    }
}
