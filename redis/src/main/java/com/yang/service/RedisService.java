package com.yang.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

//@Service
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setString(String key, String value) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    public String getString(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }


    public void setHash(String key, String filedKey, String filedValue) {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key, filedKey, filedValue);
    }

    public String getHash(String key, String filedKey){
        return (String) redisTemplate.opsForHash().get(key, filedKey);
    }
}
