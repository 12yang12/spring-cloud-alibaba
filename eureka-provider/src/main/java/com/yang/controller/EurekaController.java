package com.yang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController {


    @GetMapping("/hello")
    public String hello() {
        return "Hello Eureka Provider";
    }
}
