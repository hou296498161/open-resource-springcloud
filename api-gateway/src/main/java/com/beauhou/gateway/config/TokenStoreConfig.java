package com.beauhou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/3 0003 20:29
 */
@Configuration
public class TokenStoreConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Value("${jwt.singleKey}")
    private String singleKey="beauhou";
    @Bean
    public TokenStore tokenStore(){
        JwtTokenStore jwtTokenStore=new JwtTokenStore(jwtAccessTokenConverter());
        return jwtTokenStore;
    }


    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter=new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(singleKey);
        return jwtAccessTokenConverter;
    }
}
