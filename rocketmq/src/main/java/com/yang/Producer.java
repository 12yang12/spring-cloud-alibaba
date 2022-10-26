package com.yang;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private final RocketMQTemplate rocketMQTemplate;


    public Producer(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    public void sendMessage(String topic, String msg){
        this.rocketMQTemplate.convertAndSend(topic, msg);
    }


}
