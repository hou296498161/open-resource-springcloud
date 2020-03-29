package com.beauhou.authentication.controller;

import base.BaseController;
import base.Respond;
import com.beauhou.authentication.eo.OauthClientDetails;
import com.beauhou.authentication.server.AuthenticationServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.beauhou.fastdfs.utils.JsonUtils;

import java.util.List;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/3 0003 20:45
 */
@RestController
@RequestMapping("Authentication")

public class AuthenticationController extends BaseController {
    @Autowired
    private AuthenticationServer authenticationServer;

    private String authenticationUrl="";


    /**
     * 查询客户端details
     * @return
     */
    @GetMapping("authorClientDetailsByPage")
    public Respond authorClientDetailsByPage(Integer current, Integer size, OauthClientDetails details){
        List<OauthClientDetails> pageOauthClientDetails = authenticationServer.getPageOauthClientDetails(current, size, details);
        return buildSuccess(JsonUtils.object2Json(pageOauthClientDetails));
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("queryAllAuthorClientDetails")
    public Respond queryAllAuthorClientDetails(){
        List<OauthClientDetails> allOauthClientDetails = authenticationServer.getAllOauthClientDetails();
        return buildSuccess(JsonUtils.object2Json(allOauthClientDetails));
    }

}
