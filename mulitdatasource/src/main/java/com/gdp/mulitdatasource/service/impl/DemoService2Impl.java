package com.gdp.mulitdatasource.service.impl;

import com.gdp.mulitdatasource.annotation.DataSource;
import com.gdp.mulitdatasource.mapper.DemoMapper;
import com.gdp.mulitdatasource.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoService2Impl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;


    @Override
    @DataSource(value="demo2")
    public String testDemo() {
        int i = demoMapper.insertSql();
        if(i==0){
            return "false";
        }else{
            return "true";
        }

    }
}
