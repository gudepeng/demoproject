package com.gdp.mulitdatasource.annotation;

import java.lang.annotation.*;

/**
 * @author gudepeng
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value() default "default";
}
