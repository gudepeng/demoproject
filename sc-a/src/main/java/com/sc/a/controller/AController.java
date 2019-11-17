package com.sc.a.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AController {

   /* @Autowired
    private AConfig aConfig;*/

    @Autowired
    private BClient bClient;

    @GetMapping("/a/demo")
    @SentinelResource(value = "asdemo", blockHandler = "exceptionHandler", fallback = "fallbackHandler")
    public String asdemo(HttpServletRequest request){
        System.out.println(request.getHeader("csdemo"));
        return bClient.bsdemo();
    }

    public String fallbackHandler(HttpServletRequest request) {
        return "a service1 err";
    }

    public String exceptionHandler(HttpServletRequest request,BlockException ex) {
        return "a service2 err";
    }
}
