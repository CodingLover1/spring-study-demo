package com.ws.springbootmongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongoApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Autowired
    private MongoTemplate mongoTemplate;


    public void mongoTest(){

        Customer customer=new Customer();
        customer.setFirstName("wang");
        customer.setLastName("shuo");

        mongoTemplate.save(customer);
    }

}
