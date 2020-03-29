package com.beauhou.gateway.controller;

import base.BaseController;
import base.Respond;
import com.beauhou.fastdfs.utils.JsonUtils;
import com.beauhou.gateway.config.CustomRouteLocator;
import com.beauhou.gateway.event.RefreshRouteService;
import com.beauhou.gateway.service.ZuulConfigService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("zuulConfig")
public class ZuulConfigController extends BaseController {

    @Autowired
    ZuulConfigService service;



    @ApiOperation("新增路由")
    @PostMapping( value = "addZuulRouter")
    public Respond addZuulRouter(CustomRouteLocator.ZuulRouteVO vo){
        service.addZuulRouter(vo);
        return buildSuccess("保存成功");
    }
    @ApiOperation("修改路由")
    @PostMapping( value = "updateZuulRouter")
    public Respond updateZuulRouter(CustomRouteLocator.ZuulRouteVO vo){
        service.updateZuulRouter(vo);
        return buildSuccess("修改成功");
    }


    @ApiOperation("删除路由")
    @PostMapping( value = "removeZuulRouter")
    public Respond removeZuulRouter(CustomRouteLocator.ZuulRouteVO vo){

        return buildSuccess("删除成功");
    }

    @ApiOperation("查询所有路由")
    @GetMapping( value = "queryAllZuulRouter")
    public Respond queryAllZuulRouter(){
        List<CustomRouteLocator.ZuulRouteVO> zuulRouteVOS = service.queryAllZuulRouter();
        return buildSuccess(JsonUtils.object2Json(zuulRouteVOS));
    }

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
