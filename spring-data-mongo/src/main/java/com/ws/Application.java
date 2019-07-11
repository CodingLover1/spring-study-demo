package com.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import sun.tools.jar.CommandLine;

@SpringBootApplication
public class Application implements CommandLineRunner {

   @Autowired
   @Qualifier("userMongoTemplate")
   private MongoTemplate userTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer=new Customer("wang","shuo");
        userTemplate.save(customer);
    }
}
