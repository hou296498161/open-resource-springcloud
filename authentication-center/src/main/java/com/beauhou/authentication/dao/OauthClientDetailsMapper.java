package com.beauhou.authentication.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beauhou.authentication.eo.OauthClientDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/26 0026 20:34
 */
@Mapper
public interface OauthClientDetailsMapper extends BaseMapper<OauthClientDetails> {
}
