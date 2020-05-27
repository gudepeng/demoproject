package com.springimport.demo.config;

import com.springimport.config.Demo2Bean;
import com.springimport.demo.annotation.Demo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Demo(value="demo",title="demotitle")
@Import({Demo1Bean.class, Demo2Bean.class, DemoImportSelector.class,DemoImportBeanDefinitionRegistrar.class})
public class ImportConfig {
}
