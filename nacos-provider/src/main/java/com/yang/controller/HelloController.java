package com.yang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/provider/hello/{name}")
    public String hello(@PathVariable String name) {
        return String.format("Nacos provider %s :%s", this.port, name);
    }
}
