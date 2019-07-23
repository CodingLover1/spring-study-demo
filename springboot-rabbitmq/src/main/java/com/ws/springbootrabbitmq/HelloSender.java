package com.ws.springbootrabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author shuo.wang
 * @date 19-7-23
 */

@Service
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context="hello"+new Date();
        System.out.println("context:"+context);
        rabbitTemplate.convertAndSend("hello",context);
    }
}
