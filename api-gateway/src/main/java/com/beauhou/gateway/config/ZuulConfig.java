package com.beauhou.gateway.config;

import com.beauhou.gateway.dao.CustomZuulRouteVOMapper;
import com.beauhou.gateway.filter.APIZuulFilter;
import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/8 0008 20:47
 */
@Configuration
public class ZuulConfig {

    @Autowired
    private ZuulProperties zuulProperties;
    @Autowired
    private ServerProperties server;

    @Autowired
    private CustomZuulRouteVOMapper mapper;

    @Bean
    public APIZuulFilter zuulFilter(){
        return new APIZuulFilter();
    }

    @Bean
    public CustomRouteLocator routeLocator() {
        CustomRouteLocator routeLocator = new CustomRouteLocator( server.getServlet().getContextPath(), this.zuulProperties);
        routeLocator.setMapper(mapper);
        return routeLocator;
    }

}
