package com.beauhou.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/1 0001 20:06
 */
@SpringBootApplication
@EnableEurekaServer
public class RegisterCenterSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(RegisterCenterSpringBoot.class,args);
    }
}
