package com.yang.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @SentinelResource(value = "sayHello",blockHandler = "blockHandler")
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    public String blockHandler(String name, BlockException blockException) {
        return "blockHandler, " + name;
    }
}
