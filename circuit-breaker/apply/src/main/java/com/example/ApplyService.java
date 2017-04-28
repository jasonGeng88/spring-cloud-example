package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by jason-geng on 4/28/17.
 */
@Service
public class ApplyService {

    private final RestTemplate restTemplate;

    public ApplyService(RestTemplate rest) {
        this.restTemplate = rest;
    }

    //@HystrixCommand work in @Component or @Service
    @HystrixCommand(fallbackMethod = "reliable")
    public String apply() {
        URI uri = URI.create("http://localhost:8080/hello");

        return this.restTemplate.getForObject(uri, String.class);
    }

    public String reliable() {
        return "Hystrix...";
    }

}
