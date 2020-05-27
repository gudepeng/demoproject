package com.springimport.config;

import com.springimport.demo.bean.Bean1;
import com.springimport.demo.config.DemoClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Demo2Bean {
    @Bean
    public Bean1 bean1(){
        return new Bean1();
    }

}
