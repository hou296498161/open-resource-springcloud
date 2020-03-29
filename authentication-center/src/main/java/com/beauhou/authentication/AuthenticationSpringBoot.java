package com.beauhou.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/1 0001 20:10
 */
@SpringBootApplication
@EnableEurekaClient
public class AuthenticationSpringBoot {
    public static void main(String[] args)   {
        SpringApplication.run(AuthenticationSpringBoot.class,args);
    }

}
