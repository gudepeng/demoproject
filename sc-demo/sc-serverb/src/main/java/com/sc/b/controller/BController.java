package com.sc.b.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BController {



    @GetMapping("/b/bsdemo")
    @SentinelResource(value = "bsdemo", blockHandler = "exceptionHandler", fallback = "fallbackHandler")
    public String bsdemo(HttpServletRequest request) {
        System.out.println(request.getHeader("csdemo"));
        return "demo";
    }

    public String fallbackHandler(HttpServletRequest request) {
        return "b service1 err";
    }

    public String exceptionHandler(HttpServletRequest request,BlockException ex) {
        return "b service2 err";
    }

}
