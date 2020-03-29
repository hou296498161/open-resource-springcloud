package com.beauhou.authencation.controller;

import base.BaseController;
import base.Respond;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/5 0005 21:46
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;
    @Autowired
    private ActiveMQTopic activeMQTopic;
    /**
     * 查询用户
     * @return
     */
    @GetMapping("queryUserInfo")
    public String queryUserInfo(){

        return "";
    }

    @GetMapping("testMq")
    public Respond testMq(String msg){
        jmsMessagingTemplate.convertAndSend(queue,msg);
        return buildSuccess("发送成功");
    }
    @GetMapping("testTopic")
    public Respond testTopic(String msg){
        jmsMessagingTemplate.convertAndSend(activeMQTopic,msg);
        return buildSuccess("发送成功");
    }
}
