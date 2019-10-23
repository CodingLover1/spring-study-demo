package com.ws.config;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shuo.wang
 * @date 19-10-15
 */
@Configuration
public class CasConfiguration {

    private static final String CAS_SERVER_URL_PREFIX="https://cas.example.org:8443/";

    @Bean
    public FilterRegistrationBean filterSingleSignOutRegistration(){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        registrationBean.setFilter(new SingleSignOutFilter());
        registrationBean.addUrlPatterns("/*");
        Map<String,String> initParam=new HashMap<>();
        initParam.put("casServerUrlPrefix",CAS_SERVER_URL_PREFIX);
        registrationBean.setInitParameters(initParam);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<EventListener> singleSignOutListenerRegistration(){
        ServletListenerRegistrationBean<EventListener> registrationBean = new ServletListenerRegistrationBean<EventListener>();
        registrationBean.setListener(new SingleSignOutHttpSessionListener());
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
