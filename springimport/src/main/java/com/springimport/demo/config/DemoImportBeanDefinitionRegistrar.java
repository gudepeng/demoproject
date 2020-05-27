package com.springimport.demo.config;

import com.springimport.demo.annotation.DemoBean;
import com.springimport.demo.bean.Bean4;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class DemoImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder Bean4 = BeanDefinitionBuilder.rootBeanDefinition(Bean4.class);
        registry.registerBeanDefinition("bean4",Bean4.getBeanDefinition());
        DemoClassPathBeanDefinitionScanner definitionScanner = new DemoClassPathBeanDefinitionScanner(registry, DemoBean.class);
        definitionScanner.registerTypeFilter();
        int beanCount = definitionScanner.scan("com.springimport.demo");
    }
}
