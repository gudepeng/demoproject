package com.springimport.demo;

import com.springimport.demo.config.ImportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringImportApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportConfig.class);
        String[] beans = context.getBeanDefinitionNames();
        for (String beanName : beans) {
            Class<?> beanType = context.getType(beanName);
            System.out.println("----------------");
            System.out.println("BeanName:" + beanName);
            System.out.println("Bean所在的包：" + beanType.getPackage());
        }
        context.close();
    }
}
