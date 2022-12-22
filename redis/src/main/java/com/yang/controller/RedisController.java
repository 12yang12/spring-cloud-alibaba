package com.yang.controller;

import com.yang.service.RedisLock;
import com.yang.service.RedisService;
import com.yang.service.RedissonLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
public class RedisController {
    private final RedisService redisService;
    private final RedisLock redisLock;
    private final RedissonLock redissonLock;

    @Autowired
    public RedisController(RedisService redisService, RedisLock redisLock, RedissonLock redissonLock) {
        this.redisService = redisService;
        this.redisLock = redisLock;
        this.redissonLock = redissonLock;
    }

    @GetMapping("/getString/{key}")
    public String getString(@PathVariable("key") String key) {
        return redisService.getString(key);
    }

    @PostMapping("/setString")
    public void setString(@RequestParam("key") String key, @RequestParam("value") String value) {
        redisService.setString(key, value);
    }

    @GetMapping("/getHash/{key}/{filedKey}")
    public String getHash(@PathVariable("key") String key, @PathVariable("filedKey") String filedKey) {
        return redisService.getHash(key, filedKey);
    }

    @PostMapping("/setHash")
    public void setHash(@RequestParam("key") String key, @RequestParam("filedKey") String filedKey, @RequestParam("value") String value) {
        redisService.setHash(key, filedKey, value);
    }

    @GetMapping("/tryLock")
    public Boolean tryLock(@RequestParam("key") String key, @RequestParam("value") String value) {
        // String value = UUID.randomUUID().toString();
        return redisLock.tryLock(key, value, 600, TimeUnit.SECONDS);
    }

    @DeleteMapping("/releaseLock")
    public Long releaseLock(@RequestParam("key") String key, @RequestParam("value") String value) {
        return redisLock.releaseLock(key, value);
    }


    @GetMapping("/lock")
    public boolean lock(@RequestParam("key") String key) {
        return redissonLock.lock(key);
    }

}
