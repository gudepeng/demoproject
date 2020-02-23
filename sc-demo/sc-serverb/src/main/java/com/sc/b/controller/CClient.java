package com.sc.b.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("servicec")
public interface CClient {

    @GetMapping("/c/csdemo")
    public String csdemo();
}
