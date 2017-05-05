package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jason-geng on 5/4/17.
 */
//@Component
@RestController
@RequestMapping(value = "/store")
public class StoreIntegration {

    @HystrixCommand(fallbackMethod = "defaultStores", groupKey="g1")
    @RequestMapping(method = RequestMethod.GET)
    public String getStores() {
        throw new RuntimeException();
    }

    @HystrixCommand(fallbackMethod = "defaultStores", groupKey = "g2")
    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public String getStore() {
        return "a";
    }

    @HystrixCommand(fallbackMethod = "defaultStores", groupKey = "g1")
    @RequestMapping(value = "/b", method = RequestMethod.GET)
    public String getStoreB() {
        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "b";
    }

    public String defaultStores() {
        return "default...";
    }
}
