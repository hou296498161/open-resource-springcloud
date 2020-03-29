package com.beauhou.authencation.controller;

import base.BaseController;
import base.Respond;
import com.beauhou.authencation.eo.OauthClientDetails;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/3 0003 20:45
 */
@RestController
@RequestMapping("Authentication")
@Api(value = "查询details接口")
public class AuthenticationController extends BaseController {


    private String authenticationUrl="http://author-server/Authentication/";
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查询客户端details
     * @return
     */
    @ApiOperation("查询接口")
    @GetMapping("authorClientDetailsByPage")
    @HystrixCommand(fallbackMethod ="failMethod" )
    public Respond authorClientDetailsByPage(Integer id){
//        List<OauthClientDetails> pageOauthClientDetails = authenticationServer.getPageOauthClientDetails(current, size, details);
//        buildSuccess(JsonUtils.object2Json(pageOauthClientDetails));
        Respond respond = restTemplate.getForObject(authenticationUrl+"queryAllAuthorClientDetails", Respond.class);

        return respond;
    }

//    /**
//     * 查询所有用户
//     * @return
//     */
//    @GetMapping("queryAllAuthorClientDetails")
//    public Respond queryAllAuthorClientDetails(){
//        List<OauthClientDetails> allOauthClientDetails = authenticationServer.getAllOauthClientDetails();
//        return buildSuccess(JsonUtils.object2Json(allOauthClientDetails));
//    }

    public Respond failMethod( Integer id,Throwable  e){
        System.err.println(e.getMessage());
        return buildFail("程序出现异常！！！！："+id);
    }

}
