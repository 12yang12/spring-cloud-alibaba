package com.yang.controller;

import com.yang.entity.User;
import com.yang.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAllUser")
    public List<User> findAllUser() {
       return userService.findAllUser();
    }

    @GetMapping("/findUserById/{id}")
    public User findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PostMapping("/insertUser")
    public int insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }


}
