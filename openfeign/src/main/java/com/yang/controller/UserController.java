package com.yang.controller;

import com.yang.entity.User;
import com.yang.feignClient.UserFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserFeignClient userFeignClient;

    public UserController(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    @GetMapping("/user")
    public List<User> getUser() {
        return userFeignClient.getUser();
    }
}
