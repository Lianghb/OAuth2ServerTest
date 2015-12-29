//package com.boxfish.lhb.security.conf;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * Created by boxfish on 15/12/26.
// */
//@Configuration
////@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//
//
//    @Autowired
//    CustomUserDetailsService service;   // 自定义UserDetailService
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        logger.debug("configure(AuthenticationManagerBuilder auth)");
//        PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
//        auth.userDetailsService(service).passwordEncoder(passwordEncoder);
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/js/**","/css/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        logger.debug("configure(HttpSecurity http)");
//        System.err.println("ssssssssssssssssss---------HttpSecurity:" + http);
//        http
////                .httpBasic()
//
////                .and()
//
////                .logout()
////                .logoutUrl("/logout")
////                .invalidateHttpSession(true)
////
////                .and()
////
//                .formLogin()
//                .loginProcessingUrl("/login/login.do")
//                .loginPage("/login").permitAll()
////
////                .and()
//
////                .authorizeRequests()
////                .antMatchers(permitedUrls).permitAll()
////                .anyRequest().authenticated()
////                .antMatchers(userUrls).hasRole("USER")
////                .antMatchers(adminUrls).hasRole("ADMIN")
////                .antMatchers(dbaUrls).hasRole("DBA")
//
////                .and()
//
////                .exceptionHandling()
////                .accessDeniedPage("/login?authorization_error=true") //异常处理页面
//        ;
//    }
//
//}
//
