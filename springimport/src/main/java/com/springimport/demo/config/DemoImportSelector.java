package com.springimport.demo.config;

import com.springimport.demo.annotation.Demo;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class DemoImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(Demo.class.getName(), true);
        return new String[]{"com.springimport.demo.selectorbean.Bean2"};
    }
}
