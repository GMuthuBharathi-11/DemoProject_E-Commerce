package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT.Auth_Token_Filter;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT.Jwt_Utils;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.UserService.User_Detail_Service_Impl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
 public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final Jwt_Utils  jwtUtils;
    private final User_Detail_Service_Impl userDetailsService;

    public SecurityConfiguration(
            Jwt_Utils jwtUtils,
            User_Detail_Service_Impl userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }

    public Auth_Token_Filter authenticationJwtTokenFilter() {
        return new Auth_Token_Filter(jwtUtils);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
            .and()
            .csrf()
            .disable()
            .exceptionHandling()
            .and()
            .authorizeRequests()
            .antMatchers("/api/user/**").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

