package xyz.msprpayetonkawa.apiwebshop.retailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/retailer")
public class RetailerController {

    @Autowired
    RetailerService retailerService;

}
