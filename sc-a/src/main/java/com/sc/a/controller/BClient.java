package com.sc.a.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("serviceb")
public interface BClient {

    @GetMapping("/b/bsdemo")
    public String bsdemo();
}
