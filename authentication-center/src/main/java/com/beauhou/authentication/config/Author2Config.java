package com.beauhou.authentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/2 0002 15:59
 */
@Configuration
@EnableAuthorizationServer
public class Author2Config extends AuthorizationServerConfigurerAdapter {
   @Autowired
   private DataSource dataSource;

   @Autowired
   private PasswordEncoder passwordEncoder;
   @Autowired
   private AuthenticationUserDetailsService detailsService;

   @Autowired
   private TokenStore tokenStore;
   @Autowired
   private JwtAccessTokenConverter tokenConverter;

   @Autowired
   private AuthenticationManager manager;

   @Autowired
   private ClientDetailsService clientDetailsService;

   @Primary
   @Bean
   public PasswordEncoder passwordEncoder(){
       BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       return passwordEncoder;
   }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients()
                .tokenKeyAccess("isAuthenticated()")//允许获取token
                .checkTokenAccess("isAuthenticated()");//允许检查token


    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        JdbcClientDetailsServiceBuilder jdbc = clients.jdbc(dataSource);
        jdbc.passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.accessTokenConverter(tokenConverter)
                .userDetailsService(detailsService)
                .tokenStore(tokenStore)
                .tokenServices(tokenServices())
                .authenticationManager(manager);
    }

    @Bean
    public AuthorizationServerTokenServices tokenServices(){
        TokenEnhancerChain chain=new TokenEnhancerChain();
        chain.setTokenEnhancers(Arrays.<TokenEnhancer>asList(tokenConverter));
        DefaultTokenServices tokenServices=new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(clientDetailsService);
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setAccessTokenValiditySeconds(7200);
        tokenServices.setRefreshTokenValiditySeconds(259200);
        tokenServices.setTokenEnhancer(chain);
        return tokenServices;
    }
}
