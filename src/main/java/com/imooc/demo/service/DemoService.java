package com.imooc.demo.service;


import com.imooc.demo.domain.Demo;
import com.imooc.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    public List<Demo> list(){
        return demoMapper.selectByExample(null);
    }
}
