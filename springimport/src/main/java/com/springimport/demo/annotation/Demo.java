package com.springimport.demo.annotation;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Demo {
    String value() default "";

    String title();
}
