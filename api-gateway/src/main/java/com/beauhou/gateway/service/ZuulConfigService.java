package com.beauhou.gateway.service;

import base.Respond;
import com.beauhou.gateway.config.CustomRouteLocator;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/25 0025 16:54
 */
@Service
public interface ZuulConfigService {

     List<CustomRouteLocator.ZuulRouteVO> queryAllZuulRouter();
     void addZuulRouter(CustomRouteLocator.ZuulRouteVO vo);

     void updateZuulRouter(CustomRouteLocator.ZuulRouteVO vo);

     void removeZuulRouter(CustomRouteLocator.ZuulRouteVO vo);

    void refreshRoute();
}
