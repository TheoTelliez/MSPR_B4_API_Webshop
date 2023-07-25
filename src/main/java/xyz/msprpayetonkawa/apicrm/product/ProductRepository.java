package xyz.msprpayetonkawa.apicrm.product;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Repository
public interface ProductRepository extends Neo4jRepository<Product,Long>{

    Optional<Product> findByName();
    Optional<Product> findByUid(String id);
    @Query("CREATE (n:Product {uid: $uid,name: $name, description: $description, stock: $stock, price: $price} ) \n" +
            "RETURN n")
    Product createProduct(@Param("uid") String uid,@Param("name") String name,@Param("description") String description, @Param("stock") Integer stock, @Param("price") Float price);

}
