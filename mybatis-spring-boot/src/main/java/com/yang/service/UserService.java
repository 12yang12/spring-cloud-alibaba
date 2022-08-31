package com.yang.service;

import com.yang.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAllUser();

    public User findUserById(Integer id);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteById(Integer id);
}
