package com.ws.springbootrabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author shuo.wang
 * @date 19-7-23
 */
@Configuration
public class RabbitConfig {

    private static final String queue1="hello.msg1";
    private static final String queue2="hello.msg2";

    @Bean
    public Queue queue(){
        return new Queue(queue1);
    }

    @Bean
    public Queue queue2(){
        return  new Queue(queue2);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * TopicExchange 根据不同的routekey 将消息发送到与routekey相匹配的队列中
     * 例如: 当发送消息时 若指定routekey 为hello.msg1,则queue和queue2 队列都能收到这个消息,
     * 若为hello.msg2 则只有queu2 队列能收到这个消息
     * @param queue
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding bindExchangeA(Queue queue,TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("hello.msg1");
    }

    @Bean
    public Binding bindExchangeB(Queue queue2,TopicExchange topicExchange){
        return BindingBuilder.bind(queue2).to(topicExchange).with("hello.#");
    }

    /**
     * FanoutExchange 广播交换机,发送到该交换机的消息,会被转发到与该交换机绑定的所有队列中
     * @param queue
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding bindExchangeC(Queue queue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding bindExchangeD(Queue queue2,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue2).to(fanoutExchange);
    }





}
