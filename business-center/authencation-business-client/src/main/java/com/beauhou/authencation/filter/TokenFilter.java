package com.beauhou.authencation.filter;

import base.Respond;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.beauhou.authencation.eo.T_USER;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 解析zuul请求头中的token
 * @author beauhou
 * @version 1.0
 * @date 2020/3/15 0015 11:18
 */
//@Component
public class TokenFilter extends OncePerRequestFilter {
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String tokenMap = httpServletRequest.getHeader("tokenMap");
        System.err.println(tokenMap);
        if (!StringUtils.isEmpty(tokenMap)){
//            T_USER t_user = JSON.parseObject(tokenMap).getObject("principal",T_USER.class);
            JSONArray authors = JSON.parseObject(tokenMap).getJSONArray("authors");
            String[] strings = authors.toArray(new String[authors.size()]);
            UsernamePasswordAuthenticationToken authenticationToken=new
                    UsernamePasswordAuthenticationToken(JSON.parseObject(tokenMap).getString("principal"),null,
                    AuthorityUtils.createAuthorityList(strings)
                    );
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }else {
            //未认证通过
            httpServletResponse.setStatus(1000);
            Respond respond=new Respond(1000,"用户未登陆!!!");
            PrintWriter writer = httpServletResponse.getWriter();
            writer .println(JSON.toJSONString(respond));
            writer.close();
        }
    }
}
