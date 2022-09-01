package com.yang.dao;

import com.yang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> findAllUser();

    User findUserById(Integer id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUserById(Integer id);
}
