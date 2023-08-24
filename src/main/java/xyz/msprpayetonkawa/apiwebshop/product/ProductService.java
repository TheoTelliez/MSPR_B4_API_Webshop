package xyz.msprpayetonkawa.apiwebshop.product;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(final String uid) {
        return productRepository.findByUid(uid);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}