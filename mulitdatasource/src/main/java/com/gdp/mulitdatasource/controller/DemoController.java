package com.gdp.mulitdatasource.controller;

import com.gdp.mulitdatasource.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService2Impl;

    @Autowired
    private DemoService demoService1Impl;

    @GetMapping("/demo/{type}")
    public void testDemo(@PathVariable Integer type){
        if(type == 1){
            demoService1Impl.testDemo();
        }else{
            demoService2Impl.testDemo();
        }
    }
}
