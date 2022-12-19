package com.example.controller;

import com.example.domain.Result;
import com.example.enums.ResultEnum;
import com.example.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public Result<String> hello() throws Exception {
        int i = new Random().nextInt(10);
        if (i % 2 == 0) {
            LOGGER.info("偶数:{}", i);
            throw new MyException(ResultEnum.UNKONW_ERROR);
        } else {
            LOGGER.info("奇数{}", i);
            return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), "Hello AOP " + i);
        }
    }
}
