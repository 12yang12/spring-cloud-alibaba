package com.yang.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Component
public class RedisLock {

    private final RedisTemplate<String, Object> redisTemplate;


    public RedisLock(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Boolean tryLock(String key, Object value, long timeout, TimeUnit unit) {
        Boolean lockResult = redisTemplate.opsForValue().setIfAbsent(key, value, timeout, unit);
        if (null != lockResult && lockResult) {
            System.out.println("抢锁成功");
            System.out.println("执行业务逻辑");
        } else {
            System.out.println("抢锁失败");
        }
        return lockResult;
    }


    public Long releaseLock(String key, Object value) {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("delKey.lua")));
        redisScript.setResultType(Long.class);
        Long executeResult = redisTemplate.execute(redisScript, Collections.singletonList(key), value.toString());
        System.out.println("释放锁结果: " + executeResult);
        return executeResult;
    }
}
