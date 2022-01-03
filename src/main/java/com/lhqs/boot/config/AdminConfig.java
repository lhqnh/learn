package com.lhqs.boot.config;

import com.lhqs.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 定制mvc功能的都要实现webConfigurer
* */
@Configuration
public class AdminConfig implements WebMvcConfigurer {

    //实现添加拦截器的方法
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/toIndex","/css/**","/js/**","/fonts/**","/images/**");
    }
}
