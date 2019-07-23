package com.ws.springbootrabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author shuo.wang
 * @date 19-7-23
 */
@Component
@RabbitListener(queues="hello.msg1")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Recevier:"+hello);
    }
}
