package com.beauhou.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.beauhou.gateway.config.CustomRouteLocator;
import com.beauhou.gateway.dao.CustomZuulRouteVOMapper;
import com.beauhou.gateway.service.ZuulConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/25 0025 16:56
 */
@Service
public class ZuulConfigServiceImpl implements ZuulConfigService {

    @Autowired
    ApplicationEventPublisher publisher;

    @Autowired
    RouteLocator routeLocator;
    @Autowired
    CustomZuulRouteVOMapper mapper;

    @Override
    public void refreshRoute() {
        RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(routeLocator);
        publisher.publishEvent(routesRefreshedEvent);
    }

    @Override
    public List<CustomRouteLocator.ZuulRouteVO> queryAllZuulRouter() {
        Wrapper<CustomRouteLocator.ZuulRouteVO> wrapper=new QueryWrapper<>();
        List<CustomRouteLocator.ZuulRouteVO> zuulRouteVOS = mapper.selectList(wrapper);
        return zuulRouteVOS;
    }

    @Override
    public void addZuulRouter(CustomRouteLocator.ZuulRouteVO vo) {
        mapper.insert(vo);
        refreshRoute();
    }

    @Override
    public void updateZuulRouter(CustomRouteLocator.ZuulRouteVO vo) {
        mapper.updateById(vo);
        refreshRoute();
    }

    @Override
    public void removeZuulRouter(CustomRouteLocator.ZuulRouteVO vo) {
        mapper.deleteBatchIds(null);
        refreshRoute();
    }
}
