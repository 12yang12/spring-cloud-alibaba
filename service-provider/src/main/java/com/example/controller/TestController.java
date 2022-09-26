package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/provider")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello " + new Random().nextInt(10);
    }

    @GetMapping("/index")
    public String index() {
        return "index " + new Random().nextInt(20);
    }


}
