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


    @Autowired
    private DemoService demoService;

    @GetMapping("/list")
    public List<Demo> list(){
        return demoService.list();
    }

}
