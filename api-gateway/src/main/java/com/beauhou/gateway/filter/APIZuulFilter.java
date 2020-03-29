package com.beauhou.gateway.filter;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/8 0008 19:29
 */
import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * 处理请求参数filter
 *
 * @author :liuqi
 * @date :2018-08-29 14:11.
 */
@Component
public class APIZuulFilter extends ZuulFilter {


    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        return true;
    }

    /**
     * 将网关接收的请求头的信息转发到微服务中
     * @return
     * @throws ZuulException
     */
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof OAuth2Authentication){

            OAuth2Authentication author= (OAuth2Authentication) authentication;
            Authentication userAuthentication = author.getUserAuthentication();
            //用户信息
            String principal = userAuthentication.getName();
            List<String> authors=new CopyOnWriteArrayList<String>();
            //用户权限
            Collection<? extends GrantedAuthority> authorities = userAuthentication.getAuthorities();
            authorities.stream().forEach(value->{
                authors.add(((GrantedAuthority) value).getAuthority());
            });
            Map<String, String> requestParameters = author.getOAuth2Request().getRequestParameters();
            Map<String,Object> tokenMap=new ConcurrentHashMap<>(requestParameters);
            tokenMap.put("principal",principal);
            tokenMap.put("authors",authors);
            currentContext.addZuulRequestHeader("tokenMap", JSON.toJSONString(tokenMap));
        }
        return null;
    }
}