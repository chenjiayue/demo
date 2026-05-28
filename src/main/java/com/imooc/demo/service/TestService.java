package com.imooc.demo.service;


import com.imooc.demo.domain.Test;
import com.imooc.demo.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public List<Test> list(){
        return testMapper.list();
    }
}
