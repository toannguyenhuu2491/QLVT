//package com.qlvt.BTL.config;
//
//import com.qlvt.BTL.service.AdminService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration  {
//
//    @Autowired
//    private AdminService AdminService;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService((UserDetailsService) AdminService);
//        auth.setPasswordEncoder(passwordEncoder());
//        return auth;
//    }
//
//
//
////    @Override
////    public void configure(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .antMatchers("/home", "/page1").authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .defaultSuccessURL("/home")
////                .and()
////                .logout()
////                .permitAll();
////    }
//
//
//
//}