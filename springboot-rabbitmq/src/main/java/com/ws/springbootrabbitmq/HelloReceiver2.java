package com.ws.springbootrabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author shuo.wang
 * @date 19-7-23
 */

@Component
@RabbitListener(queues = "hello.msg2")
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String msg){
        System.out.println("Receiver2:"+msg);
    }
}
