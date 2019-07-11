package com.ws.controller;

import com.ws.service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private ServiceB serviceB;

    @RequestMapping("/greet")
    public String greet(){
        return serviceB.getHello()+" World!";
    }

}
