package com.beauhou.authentication.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beauhou.authentication.eo.T_USER;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/3 0003 22:00
 */
@Mapper
public interface UserMapper extends BaseMapper<T_USER> {

}
