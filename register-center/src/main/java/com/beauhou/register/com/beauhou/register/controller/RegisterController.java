package com.beauhou.register.com.beauhou.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/26 0026 15:59
 */
@RestController
@RequestMapping("eurekaInfo")
public class RegisterController {

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("getAllServiceInfo")
    public List<ServiceInstance> serviceUrl() {
        List<ServiceInstance> results=new ArrayList<>();
        List<String> services = discoveryClient.getServices();

        services.forEach(value->{
            results.addAll(discoveryClient.getInstances(value));
        });

        return results;
    }
}
