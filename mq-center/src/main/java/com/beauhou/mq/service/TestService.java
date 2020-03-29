package com.beauhou.mq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/17 0017 20:47
 */
@Component
public class TestService {

    /**
     * 客户端消费
     * @param consumer
     */
    @JmsListener(destination = "demo")
    public void receiveQueue(String consumer) {
        System.out.println("收到消息：：："+consumer);
    }

//    /**
//     * 客户端消费
//     * @param consumer
//     */
//    @JmsListener(destination = "demo",containerFactory ="jmsListenerContainerTopic")
//    public void receiveTopic(String consumer) {
//        System.out.println("收到消息：：："+consumer);
//    }
}
