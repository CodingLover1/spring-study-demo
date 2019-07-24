package com.ws.springbootmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringbootMongoApplication implements CommandLineRunner {
    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer=new Customer();
        customer.setLastName("shuo");
        customer.setFirstName("wang");
        mongoTemplate.save(customer);
        System.out.println(customer);
    }
}
