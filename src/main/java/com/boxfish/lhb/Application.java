package com.boxfish.lhb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by boxfish on 15/12/14.
 */

@SpringBootApplication
//@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


//    @RequestMapping("/")
//    public String home() {
//        return "Hello world!";
//    }

//    @Configuration
//    @EnableResourceServer
//    protected static class ResourceConfig extends ResourceServerConfigurerAdapter {
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http.requestMatcher(new OrRequestMatcher(new AntPathRequestMatcher("/"),
//                    new AntPathRequestMatcher("/admin/beans")))
//                    .authorizeRequests()
//                    .anyRequest().access("#oauth2.hasScope('read')");
//        }
//
//        @Override
//        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//            resources.resourceId("sparklr");
//        }
//    }
//
//
//    @Configuration
//    @EnableAuthorizationServer
//    protected static class OAuth2ServerConfig extends AuthorizationServerConfigurerAdapter {
//
//
//        @Autowired
//        AuthenticationManager authenticationManager;
//
//
//        @Override
//        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//            endpoints.authenticationManager(authenticationManager);
//        }
//
//        @Override
//        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//            // @formatter:off
//            clients.inMemory().withClient("my-trusted-client")
//                    .authorizedGrantTypes("password", "authorization_code",
//                            "refresh_token", "implicit")
//                    .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//                    .scopes("read", "write", "trust").resourceIds("sparklr")
//                    .accessTokenValiditySeconds(60).and()
//                    .withClient("my-client-with-registered-redirect")
//                    .authorizedGrantTypes("authorization_code").authorities("ROLE_CLIENT")
//                    .scopes("read", "trust").resourceIds("sparklr")
//                    .redirectUris("http://anywhere?key=value").and()
//                    .withClient("my-client-with-secret")
//                    .authorizedGrantTypes("client_credentials", "password")
//                    .authorities("ROLE_CLIENT").scopes("read").resourceIds("sparklr")
//                    .secret("secret")
//                    .and()
//                    .withClient("client1")
//                    .secret("123456")
//                    .authorities("ROLE_CLIENT")
//                    .authorizedGrantTypes("password", "authorization_code",
//                            "refresh_token", "implicit")
//                    .scopes("read", "write", "trust", "haha")
//                    .resourceIds("sparklr")
//                    .accessTokenValiditySeconds(60)
//                    .redirectUris("http://localhost:8080/");
//            // @formatter:on
//        }
//    }

}