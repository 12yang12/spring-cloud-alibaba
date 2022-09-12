package com.yang.controller;

import com.yang.service.RedisService;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisController {
    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
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
}
