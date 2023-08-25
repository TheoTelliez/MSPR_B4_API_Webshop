package xyz.msprpayetonkawa.apiwebshop.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.msprpayetonkawa.apiwebshop.retailer.Retailer;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findByUid(String id);
    List<Product> findProductsByRetailerUid(String uid);

}
