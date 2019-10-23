package com.ws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shuo.wang
 * @date 19-10-11
 */

@RestController
public class TestController {
    @GetMapping("/test")
    public String get(HttpServletRequest request){
        request.getUserPrincipal();
        return "test success";
    }
}
