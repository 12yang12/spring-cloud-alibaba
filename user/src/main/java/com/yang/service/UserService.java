package com.yang.service;

import com.yang.entity.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private static final Map<Integer, User> userMap = new HashMap<>(8);

    static {
        userMap.put(1, new User(1, "zhang", 11, "man"));
        userMap.put(2, new User(2, "wang", 20, "man"));
        userMap.put(3, new User(3, "li", 30, "woman"));
    }

    public List<User> getUser(){
        return new ArrayList<>(userMap.values());
    }
}
