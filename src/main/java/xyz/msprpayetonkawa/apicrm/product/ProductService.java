package xyz.msprpayetonkawa.apicrm.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;

@Data
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> getProduct(final String uid) {
        return productRepository.findByUid(uid);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}