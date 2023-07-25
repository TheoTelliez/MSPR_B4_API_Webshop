package xyz.msprpayetonkawa.apicrm.product;

import java.util.Optional;
import java.util.UUID;

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

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public void deleteProducts(final Long id) {
        productRepository.deleteById(id);
    }

    public Product saveProducts(Product product) {
        product.setUid(String.valueOf(UUID.randomUUID()));
        return productRepository.createProduct(product.getUid(),product.getName(),product.getDescription(),product.getStock(),product.getPrice());
    }



}