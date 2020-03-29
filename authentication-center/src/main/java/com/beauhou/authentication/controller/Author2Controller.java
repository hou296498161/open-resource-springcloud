package com.beauhou.authentication.controller;

import base.BaseController;
import base.Respond;
import com.beauhou.authentication.eo.OauthClientDetails;
import com.beauhou.authentication.service.OauthDetailsService;
import com.beauhou.fastdfs.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/16 0016 21:01
 */
@RestController
@RequestMapping("oauth")
@Api(tags = "认证管理服务")
public class Author2Controller extends BaseController {

    @Autowired
    private TokenEndpoint tokenEndPoint;
    @Autowired
    private OauthDetailsService service;

    @PostMapping("/token")
    @ApiOperation(value = "clientId获取token")
    public Respond getToken(Principal principal){
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("client_id", "user-client");
        parameters.put("client_secret", "123456");
        parameters.put("grant_type", "password");
        parameters.put("username", "test");
        parameters.put("password", "123456");
        // 直接调用 /oauth/token 映射的方法，不在通过url调用获取token
        try {
            ResponseEntity<OAuth2AccessToken> result = tokenEndPoint.getAccessToken(principal, parameters);

        } catch (HttpRequestMethodNotSupportedException e) {
            e.printStackTrace();
        }
        return buildSuccess();
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "查看授权信息")
    @GetMapping("queryOauthDetails")
    public Respond queryOauthDetails(){
        List<OauthClientDetails> oauthClientDetails = service.queryOauthDetails();


        return buildSuccess(JsonUtils.object2Json(oauthClientDetails));
    }

}
