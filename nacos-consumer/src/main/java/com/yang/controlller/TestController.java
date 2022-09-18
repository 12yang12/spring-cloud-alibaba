package com.yang.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    private final RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping(value = "/consumer/hello/{name}")
    public String hello(@PathVariable String name) {
        return restTemplate.getForObject("http://nacos-service-provider/provider/hello/" + name, String.class);
    }
}
