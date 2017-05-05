package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * Created by jason-geng on 4/28/17.
 */
@RestController
public class ApplyController {

    @Autowired
    private ApplyService applyService;
//    @Autowired
//    private StoreIntegration storeIntegration;

    @RequestMapping("/apply")
    public String apply(){
//        return storeIntegration.getStores();
        URI uri = URI.create("http://localhost:8080/hello");

        return applyService.apply();
    }
}
