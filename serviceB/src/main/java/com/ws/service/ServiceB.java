package com.ws.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="serviceA", url="http://localhost:8080/")
public interface ServiceB {

    @RequestMapping(value="/service",method = RequestMethod.GET)
    String getHello();

}
