package com.springimport.demo.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;

public class DemoClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {
    private Class type;
    public DemoClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, Class<? extends Annotation> type){
        super(registry,false);
        this.type = type;
    }

    public void registerTypeFilter(){
        addIncludeFilter(new AnnotationTypeFilter(type));
    }
}
