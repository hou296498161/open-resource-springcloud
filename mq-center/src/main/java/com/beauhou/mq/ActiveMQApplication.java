package com.beauhou.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/17 0017 20:33
 */
@SpringBootApplication
@EnableJms
public class ActiveMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActiveMQApplication.class,args);
    }
}
