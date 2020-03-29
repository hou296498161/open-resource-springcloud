package com.beauhou.authentication.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.beauhou.authentication.dao.OauthClientDetailsMapper;
import com.beauhou.authentication.eo.OauthClientDetails;
import com.beauhou.authentication.service.OauthDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/26 0026 20:52
 */
@Service
@Slf4j
public class OauthDetailsServiceImpl implements OauthDetailsService {

    @Autowired
    private OauthClientDetailsMapper mapper;
    @Override
    public List<OauthClientDetails> queryOauthDetails() {
        Wrapper<OauthClientDetails> wrapper=new QueryWrapper<>();
        List<OauthClientDetails> oauthClientDetails = mapper.selectList(wrapper);
        return oauthClientDetails;
    }

    @Override
    public void addOauthDetails(OauthClientDetails details) {
        mapper.insert(details);
    }

    @Override
    public void updateOauthDetails(OauthClientDetails details) {
        mapper.updateById(details);
    }
}
