package com.imooc.demo.controller;

import com.imooc.demo.domain.Demo;
import com.imooc.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    //@Value("${demo.hello}")
    //private String demoHello;

    @Autowired
    private DemoService demoService;

    //@RequestMapping(value = "/hello",method = RequestMethod.GET)
    //public String hello(){
    //    return "hello world!!!" + demoHello;
    //}

    //@RequestMapping(value = "/hello/post",method = RequestMethod.POST)
    //public String helloPost(String name){
    //    return "hello world!!!" + name;
    //}

    @GetMapping("/list")
    public List<Demo> list(){
        return demoService.list();
    }

}
