package com.yang.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class RedisLock {

    private final RedisTemplate<String, Object> redisTemplate;


    public RedisLock(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void doSomething() {
        String key = "lockKey";
        String value = UUID.randomUUID().toString();
        long timeout = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        try {
            Boolean lockResult = lock(key, value, timeout, unit);
            if (lockResult) {
                System.out.println("抢锁成功");
                System.out.println("执行业务逻辑");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseLock(key, value);
        }
    }

    public Boolean lock(String key, Object value, long timeout, TimeUnit unit) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, timeout, unit);

    }

    public void releaseLock(String key, Object value) {
        if (value.equals(redisTemplate.opsForValue().get(key))) {
            redisTemplate.delete(key);
        }
    }
}
