package com.beauhou.gateway.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beauhou.gateway.config.CustomRouteLocator;
import com.beauhou.gateway.vo.CustomZuulRouteVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/24 0024 21:28
 */
@Mapper
public interface CustomZuulRouteVOMapper extends BaseMapper<CustomRouteLocator.ZuulRouteVO> {

}
