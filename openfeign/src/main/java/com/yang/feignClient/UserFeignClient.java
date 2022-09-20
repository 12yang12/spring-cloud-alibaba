package com.yang.feignClient;

import com.yang.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("user")
public interface UserFeignClient {

    @GetMapping(value = "/user")
    List<User> getUser();

}

