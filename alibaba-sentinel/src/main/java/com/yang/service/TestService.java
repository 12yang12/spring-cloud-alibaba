package com.yang.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TestService {


    @SentinelResource(value = "hello", blockHandler = "helloBlockHandler", fallback = "helloFallback")
    public String hello(@PathVariable String name) throws Exception {
        if ("1".equals(name)) {
            throw new Exception("触发熔断");
        }
        return "Hello Sentinel";
    }

    public String helloBlockHandler(String name, BlockException blockException) {
        System.out.println("Sentinel 限流");
        return "Sentinel blockHandler";
    }

    public String helloFallback(String name, Throwable throwable) {
        System.out.println("Sentinel 熔断");
        return "Sentinel helloFallback";
    }
}
