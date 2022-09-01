package com.yang.service;

import com.yang.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    User findUserById(Integer id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUserById(Integer id);
}
