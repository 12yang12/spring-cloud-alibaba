package com.yang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${rocketmq.consumer.topic}")
    private String topic;

    private Producer producer;

    @Autowired
    public Controller(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/rocketmq/{message}")
    public String sendMessage(@PathVariable String message) {
        this.producer.sendMessage(topic, message);
        return "消息发送完成";
    }

}
