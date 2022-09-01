package com.yang.service.impl;

import com.yang.dao.UserMapper;
import com.yang.entity.User;
import com.yang.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userRepository;

    public UserServiceImpl(UserMapper userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAllUser();
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }

    @Override
    public int insertUser(User user) {
        return userRepository.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userRepository.deleteUserById(id);
    }
}
