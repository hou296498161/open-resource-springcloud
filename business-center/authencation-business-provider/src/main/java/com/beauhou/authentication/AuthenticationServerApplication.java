package com.beauhou.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/8 0008 16:42
 */
@SpringBootApplication
@EnableEurekaClient
public class AuthenticationServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationServerApplication.class,args);
    }
}
