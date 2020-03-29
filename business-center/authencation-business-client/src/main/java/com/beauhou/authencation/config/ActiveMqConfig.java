package com.beauhou.authencation.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/17 0017 20:40
 */
@Component
public class ActiveMqConfig {
    @Bean
    public ActiveMQQueue queue() {
        return new ActiveMQQueue("demo");
    }

    @Bean
    public ActiveMQTopic topic(){

        return new ActiveMQTopic("demo");
    }
}
