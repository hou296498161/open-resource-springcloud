package com.beauhou.authentication.server.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beauhou.authentication.dao.AuthenticationMapper;
import com.beauhou.authentication.eo.OauthClientDetails;
import com.beauhou.authentication.server.AuthenticationServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/6 0006 13:41
 */
@Service
public class AuthenticationServerImpl implements AuthenticationServer {
    @Autowired
    private AuthenticationMapper authenticationMapper;

    public OauthClientDetails getOauthClientDetailsByClientId(String clientId) {
        OauthClientDetails oauthClientDetails = authenticationMapper.selectById(clientId);
        return oauthClientDetails;
    }

    public void saveOauthClientDetails(OauthClientDetails oauthClientDetails) {
        authenticationMapper.insert(oauthClientDetails);
    }

    public void removeOauthClientDetails(OauthClientDetails oauthClientDetails) {
        authenticationMapper.deleteById(oauthClientDetails.getClientId());
    }

    public void updateOauthClientDetails(OauthClientDetails oauthClientDetails) {
        authenticationMapper.updateById(oauthClientDetails);
    }

    public List<OauthClientDetails> getAllOauthClientDetails() {
        List<OauthClientDetails> oauthClientDetails = authenticationMapper.queryAllOauthClientDetails();
        return oauthClientDetails;
    }

    public List<OauthClientDetails> getPageOauthClientDetails(Integer current,Integer size,OauthClientDetails details) {

        QueryWrapper<OauthClientDetails> oauthClientDetailsQueryWrapper = new QueryWrapper<OauthClientDetails>();
        Page<OauthClientDetails> page = new Page<OauthClientDetails>(current,size);
//        List<OauthClientDetails> oauthClientDetails = authenticationMapper.queryOauthClientDetailsByPage(page);
        IPage<OauthClientDetails> oauthClientDetailsIPage = authenticationMapper.selectPage(page, oauthClientDetailsQueryWrapper);
        List<OauthClientDetails> records = oauthClientDetailsIPage.getRecords();
        return records;
    }

}
