package com.imooc.demo.controller;

import com.imooc.demo.domain.Test;
import com.imooc.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Value("${test.hello}")
    private String testHello;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world!!!" + testHello;
    }

    @RequestMapping(value = "/hello/post",method = RequestMethod.POST)
    public String helloPost(String name){
        return "hello world!!!" + name;
    }

    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }
}
