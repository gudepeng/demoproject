package com.sc.c.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CController {


    @GetMapping("/c/csdemo")
    public String csdemo(HttpServletRequest request) {
        System.out.println(request.getHeader("csdemo"));
        return "hello c service";
    }

}
