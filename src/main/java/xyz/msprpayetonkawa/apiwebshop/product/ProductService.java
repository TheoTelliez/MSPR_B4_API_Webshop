package xyz.msprpayetonkawa.apiwebshop.product;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.msprpayetonkawa.apiwebshop.retailer.Retailer;
import xyz.msprpayetonkawa.apiwebshop.retailer.RetailerService;

import java.util.Collections;
import java.util.List;

@Data
@Service
public class ProductService {

    @Autowired
    private RetailerService retailerService;

    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(final String uid) {
        return productRepository.findByUid(uid);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByRetailer(String uid){
        return productRepository.findProductsByRetailerUid(uid);
    }


}