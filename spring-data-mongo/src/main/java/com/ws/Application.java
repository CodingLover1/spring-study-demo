package com.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.tools.jar.CommandLine;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {

        customerRepository.deleteAll();

        customerRepository.save(new Customer("shuo","wang"));
        customerRepository.save(new Customer("meng","wang"));

        System.out.println("all custmoer:");
        for(Customer c:customerRepository.findAll()){
            System.out.println(c);
        }

    }
}
