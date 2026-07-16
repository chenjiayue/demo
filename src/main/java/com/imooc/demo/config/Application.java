/*package com.imooc.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;*/
/*
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan("com")
@MapperScan("com.imooc.demo.mapper")
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        Environment env = app.run(args).getEnvironment();
        System.out.println("启动成功！!");
        System.out.println("根地址: \t\thttp://127.0.0.1:" + env.getProperty("server.port"));
        System.out.println("登录接口: \thttp://127.0.0.1:" + env.getProperty("server.port") + "/user/login?loginName=test&password=test");
    }

}*/
package com.imooc.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan("com.imooc.demo")
@MapperScan("com.imooc.demo.mapper")
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        Environment env = context.getEnvironment();
        String port = env.getProperty("server.port", "8080");

        LOG.info("启动成功！！");
        LOG.info("根地址: \t\thttp://127.0.0.1:{}", port);
        LOG.info("登录接口: \thttp://127.0.0.1:{}/user/login?loginName=test&password=test", port);

        System.out.println("启动成功！！");
        System.out.println("根地址: \t\thttp://127.0.0.1:" + port);
        System.out.println("登录接口: \thttp://127.0.0.1:" + port + "/user/login?loginName=test&password=test");
    }

}
