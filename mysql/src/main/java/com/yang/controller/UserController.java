package com.yang.controller;

import com.yang.entity.User;
import com.yang.dao.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/selectAllUser")
    public List<User> selectAllUser() {
        List<User> userList = jdbcTemplate.query("select * from user", new UserRowMapper());

        for (User user : userList) {
            System.out.println(user);
        }

        return userList;
    }

    @PostMapping("/addUser")
    public int addUser(@RequestBody User user) {
        return jdbcTemplate.update("INSERT INTO user (NAME, AGE, SEX) VALUES (?, ?, ?);", user.getName(), user.getAge(), user.getSex());
    }


    @DeleteMapping("/deleteUser/{name}/{age}")
    public int deleteUser(@PathVariable String name, @PathVariable int age) {
        return jdbcTemplate.update("delete from user where name=? and age=?;", name, age);
    }

}
