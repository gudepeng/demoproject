package com.gdp.mulitdatasource.aspect;

import com.gdp.mulitdatasource.annotation.DataSource;
import com.gdp.mulitdatasource.datasource.DataSourceThreadLocal;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(-1)
public class DataSourceAspect {

    @Around("@annotation(com.gdp.mulitdatasource.annotation.DataSource)")
    public Object aspectDataSource(ProceedingJoinPoint point){
        try {
            //获得当前访问的class
            Class<?> className = point.getTarget().getClass();
            //获得访问的方法名
            String methodName = point.getSignature().getName();
            //得到方法的参数的类型
            Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
            String dataSource = "default";
            try {
                // 得到访问的方法对象
                //Method method = className.getMethod(methodName, argClass);
                Method method = BeanUtils.findDeclaredMethod(className,methodName, argClass);
                // 判断是否存在@DS注解
                if (method.isAnnotationPresent(DataSource.class)) {
                    DataSource annotation = method.getAnnotation(DataSource.class);
                    // 取出注解中的数据源名
                    dataSource = annotation.value();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            DataSourceThreadLocal.set(dataSource);
            Object value = point.proceed();
            return value;
        }catch (Exception e){
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            DataSourceThreadLocal.clean();
        }
        return null;
    }

}
