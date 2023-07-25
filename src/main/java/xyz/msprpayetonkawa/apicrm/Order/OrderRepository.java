package xyz.msprpayetonkawa.apicrm.Order;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xyz.msprpayetonkawa.apicrm.client.Customer;
import xyz.msprpayetonkawa.apicrm.product.Product;

import java.util.Date;
import java.util.Optional;

@Repository
public interface OrderRepository extends Neo4jRepository<Order, Long> {

    Optional<Order> findByUid(String id);
    @Query("CREATE (n:Order {uid: $uid, dateCreated: $dateCreated, customer: $customer} ) \n" +
            "RETURN n")
    Product getOrderByCustomer(@Param("uid") String uid, @Param("dateCreated") Date dateCreated, @Param("customer") Customer customer);

}
