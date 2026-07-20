package com.imooc.demo.config;

import com.imooc.demo.interceptor.ActionInterceptor;
import com.imooc.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.imooc.demo.interceptor.LogInterceptor;

import javax.annotation.Resource;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Resource
    LoginInterceptor loginInterceptor;

    @Resource
    ActionInterceptor actionInterceptor;

    @Resource
    LogInterceptor logInterceptor;


    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**");
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/login",
                        "/demo/**",
                        "/hello/**",
                        "/test/**",
                        "/redis/**",
                        "/user/login",
                        "/category/all",
                        "/ebook/list",
                        "/doc/all/**",
                        "/doc/vote/**",
                        "/doc/find-content/**",
                        "/ebook-snapshot/**"
                );
        registry.addInterceptor(actionInterceptor)
                .addPathPatterns(
                        "/*/save",
                        "/*/delete/**",
                        "/*/reset-password");
    }
}
