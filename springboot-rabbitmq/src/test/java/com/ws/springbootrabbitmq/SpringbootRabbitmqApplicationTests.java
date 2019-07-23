package com.ws.springbootrabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private HelloSender helloSender;

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Test
	public void send(){
		helloSender.send();
	}


	@Test
	public void topicExchangeTest(){
		amqpTemplate.convertAndSend("topicExchange","hello.msg1","ha ha ha~");
		amqpTemplate.convertAndSend("topicExchange","hello.msg2","ni hao a ~");
	}

	@Test
	public void fanoutExchangeTest(){
		amqpTemplate.convertAndSend("fanoutExchange", "","ha ha ha~");
		amqpTemplate.convertAndSend("fanoutExchange","","ni hao a ~");
	}




}
