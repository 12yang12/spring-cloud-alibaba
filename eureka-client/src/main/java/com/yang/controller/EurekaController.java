package com.yang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaController {
    private final RestTemplate restTemplate;

    public EurekaController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hello")
    public String hello() {
        return restTemplate.getForObject("http://eureka-provider/hello", String.class);
    }
}
