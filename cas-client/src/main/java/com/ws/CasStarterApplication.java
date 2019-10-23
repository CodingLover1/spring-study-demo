package com.ws;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shuo.wang
 * @date 19-10-11
 */

@EnableCasClient
@SpringBootApplication
public class CasStarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CasStarterApplication.class,args);
    }
}
