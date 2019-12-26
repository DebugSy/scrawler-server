package com.shiy.practice.scrawler.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().anonymous()
                .and().servletApi()
                .and().headers().cacheControl()
                .and().frameOptions().disable();
        http.authorizeRequests()
                .anyRequest().permitAll()
                .antMatchers("/api/scrawler/swagger.json").permitAll()
                .anyRequest().permitAll();
    }
}
