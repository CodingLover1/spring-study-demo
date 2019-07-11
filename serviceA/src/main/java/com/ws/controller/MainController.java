package com.ws.controller;


import com.ws.service.HelloServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private HelloServiceA serviceA;


    @GetMapping("/service")
    @ResponseBody
    public String hello(){
        return serviceA.sayGreet();
    }
}
