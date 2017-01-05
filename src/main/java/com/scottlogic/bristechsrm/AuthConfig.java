package com.scottlogic.bristechsrm;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class AuthConfig {

    @Bean
    public FilterRegistrationBean someFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(authFilter());
        registration.setName("authFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean(name = "authFilter")
    public Filter authFilter() {
        return new AuthFilter();
    }
}
