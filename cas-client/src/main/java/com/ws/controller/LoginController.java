package com.ws.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author shuo.wang
 * @date 19-10-15
 */

@RestController
public class LoginController {


    private String casServerUrl="https://cas.example.org:8443/cas/logout";



    @GetMapping("/logout")
    public void  logout(HttpSession session, HttpServletRequest request, HttpServletResponse response)throws Exception {
        session.invalidate();
        response.sendRedirect(casServerUrl);
    }
}
