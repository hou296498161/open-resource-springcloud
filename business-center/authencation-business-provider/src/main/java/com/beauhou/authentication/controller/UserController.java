package com.beauhou.authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/5 0005 21:46
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 查询用户
     * @return
     */
    @GetMapping("queryUserInfo")
    public String queryUserInfo(){

        return "";
    }
}
