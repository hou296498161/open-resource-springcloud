package com.beauhou.authentication.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beauhou.authentication.eo.OauthClientDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/6 0006 13:39
 */
@Mapper
public interface AuthenticationMapper extends BaseMapper<OauthClientDetails> {

    @Select("select * from OAUTH_CLIENT_DETAILS")
    List<OauthClientDetails> queryAllOauthClientDetails();

}
