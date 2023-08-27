package xyz.msprpayetonkawa.apiwebshop.retailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RetailerService {

    @Autowired
    RetailerRepository retailerRepository;

    @Value("${customer.password}")
    private String defaultPassword;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Retailer getRetailerByUid(String uid) {
        return retailerRepository.findByUid(uid);
    }

    public List<Retailer> getRetailers() {
        return retailerRepository.findAll();
    }

}
