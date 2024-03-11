package com.yang.service;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

//@Component
public class RedissonLock {

    private final RedissonClient redissonClient;

    public RedissonLock(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    public boolean lock(String key) {
        RLock lock = redissonClient.getLock(key);
        boolean lockResult = lock.tryLock();
        if (lockResult) {
            try {
                System.out.println("抢锁成功");
                System.out.println("执行业务逻辑");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("抢锁失败");
        }

        return lockResult;
    }

}
