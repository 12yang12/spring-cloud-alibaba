package com.yang.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DegradeController {

    @GetMapping("/degrade/{name}")
    @SentinelResource(value = "degrade", fallback = "degradeFallback")
    public String degrade(@PathVariable("name") String name) {
        if ("1".equals(name)) {
            throw new IllegalArgumentException("invalid arg");
        }

        return String.format("Hello %s", name);
    }

    public static String degradeFallback(String name, Throwable throwable) {
        System.out.println(throwable.getMessage());
        return "degrade 服务降级";
    }

}
