package com.beauhou.authentication.config;


import ch.qos.logback.core.rolling.helper.TokenConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/2 0002 15:48
 * jwtToken配置
 */
@Configuration
public class JWTTokenStoreConfig {

    private String singleKey="beauhou";

    @Bean
    public TokenStore tokenStore(){
        JwtTokenStore jwtTokenStore = new JwtTokenStore(tokenConverter());
        return jwtTokenStore;
    }

    @Bean
    public JwtAccessTokenConverter  tokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter=new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(singleKey);
        return jwtAccessTokenConverter;
    }
}
