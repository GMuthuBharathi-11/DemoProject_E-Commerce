package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT.AuthEntryJwt;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT.AuthTokenFilter;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT.JwtUtils;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.UserService.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
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

    private final JwtUtils jwtUtils;
    private final AuthEntryJwt authEntryJwt;

    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfiguration(
            JwtUtils jwtUtils,AuthEntryJwt authEntryJwt,
            @Lazy UserDetailsServiceImpl userDetailsService)
    {
        this.jwtUtils           = jwtUtils;
        this.authEntryJwt = authEntryJwt;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter(jwtUtils);
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
            .authenticationEntryPoint(authEntryJwt)
            .and()
            .authorizeRequests()
            .antMatchers("/api/user/**").permitAll()
            .antMatchers("/api/forget/**").permitAll()
            .antMatchers("/api/admin/**").permitAll()
            .antMatchers("/api/seller/**").permitAll()
            .antMatchers("/address/add").permitAll()
            .antMatchers("api/customer/**").permitAll()
            .antMatchers("/customer/register").permitAll()
            .antMatchers("/seller/register").permitAll()
            .antMatchers("/login").permitAll()
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

