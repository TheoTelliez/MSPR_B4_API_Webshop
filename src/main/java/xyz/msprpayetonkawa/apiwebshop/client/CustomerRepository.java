package xyz.msprpayetonkawa.apiwebshop.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByUid(String uid);
    Optional<Customer> findByEmail(String email);
}
