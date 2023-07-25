package xyz.msprpayetonkawa.apicrm.client;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xyz.msprpayetonkawa.apicrm.product.Product;

import java.util.Optional;

@Repository
public interface CustomerRepository extends Neo4jRepository<Customer, Long> {

   /* Optional<Customer> findByUid(String id);
    @Query("CREATE (n:Product {uid: $uid,name: $name, description: $description, stock: $stock, price: $price} ) \n" +
            "RETURN n")
    Product createProduct(@Param("uid") String uid, @Param("name") String name, @Param("description") String description, @Param("stock") Integer stock, @Param("price") Float price);
*/
}
