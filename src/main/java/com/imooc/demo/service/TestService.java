package com.imooc.demo.service;

import com.imooc.demo.domain.Test;
import com.imooc.demo.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//加上@Service注解，表示该类被Spring管理
//Autowired注解，表示自动注入 jdk自带
//Resource注解，表示自动注入 spring自带
@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public List<Test> list(){
        return testMapper.list();
    }
}
