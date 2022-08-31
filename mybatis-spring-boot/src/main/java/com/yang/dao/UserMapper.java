package com.yang.dao;

import com.yang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    public List<User> findAllUser();

    public User findUserById(Integer id);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteById(Integer id);
}
