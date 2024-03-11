package com.yang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class RedisSequenceGenerator {

    private final RedisTemplate<String, Long> redisTemplate;
    private final RedisScript<Long> sequenceScript;

    @Autowired
    public RedisSequenceGenerator(RedisTemplate<String, Long> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.sequenceScript = createSequenceScript();
    }

    private RedisScript<Long> createSequenceScript() {
        DefaultRedisScript<Long> script = new DefaultRedisScript<>();
        script.setScriptSource(new ResourceScriptSource(new ClassPathResource("sequence.lua")));
        script.setResultType(Long.class);
        return script;
    }


    public Long getNextValue(String key, long maxValue) {
        return redisTemplate.execute(sequenceScript, Collections.singletonList(key), maxValue);
    }
}