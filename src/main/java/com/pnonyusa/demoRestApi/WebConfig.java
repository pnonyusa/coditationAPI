package com.pnonyusa.demoRestApi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// this Global CORS configuration allows any http request to access the api controllers

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }
}
