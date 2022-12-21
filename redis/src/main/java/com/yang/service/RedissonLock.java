package com.yang.service;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Component
public class RedissonLock {

    private final RedissonClient redissonClient;

    public RedissonLock(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    public void doSometingWithLock() {
        String key = "";
        RLock lock = redissonClient.getLock(key);
        try {
            boolean lockResult = lock.tryLock();
            if (lockResult) {
                System.out.println("业务逻辑");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
