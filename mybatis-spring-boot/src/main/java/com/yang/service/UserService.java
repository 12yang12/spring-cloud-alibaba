package com.yang.service;

import com.yang.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    User findUserById(int id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteById(Integer id);
}
