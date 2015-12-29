
package com.boxfish.lhb.security.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * Created by boxfish on 15/12/19.
 */

/**
 * 认证服务器配置
 */
@Configuration
public class OAuth2ServerConfiguration {

    public static final String RESOURCE_ID = "test_resource";

    /**
     * 资源服务器配置
     */
    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfig extends ResourceServerConfigurerAdapter {
        private Logger logger = LoggerFactory.getLogger(getClass());

        @Override
        public void configure(HttpSecurity http) throws Exception {
            logger.debug("configure(HttpSecurity http)");
            System.err.println("rrrrrrrrrrrrrrrr----------HttpSecurity:" + http);
            http
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .requestMatchers()
                    .antMatchers("/photos/**", "/oauth/users/**", "/oauth/clients/**", "/me")
                    .and()
                    .authorizeRequests()
                    .antMatchers("/me").access("#oauth2.hasScope('read')")
                    .antMatchers("/photos").access("#oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_USER'))")
            ;
        }

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId(RESOURCE_ID);
        }
    }


    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


        //        @Autowired
//        private TokenStore tokenStore;
//
//        @Autowired
//        private UserApprovalHandler userApprovalHandler;
//
        @Autowired
//        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory()
                    .withClient("client1") //客户端id
                    .secret("123456") //客户端密码
                    .resourceIds(RESOURCE_ID) //资源id
                    .accessTokenValiditySeconds(60) //token有效时间1分钟
                    .refreshTokenValiditySeconds(60) //重新获取token有效时间1分钟
                    .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
                    .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//                    .autoApprove(true)
//                    .autoApprove("read")
                    .scopes("read", "write", "trust")
                    .redirectUris("http://localhost:8080");
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.authenticationManager(authenticationManager)  //必须添加认证管理器，不然会提示认证不支持
//                    .tokenStore(new InMemoryTokenStore())
            ;

        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
            super.configure(security);
        }
    }
}

