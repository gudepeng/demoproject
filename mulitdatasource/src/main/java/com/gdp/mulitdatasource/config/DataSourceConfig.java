package com.gdp.mulitdatasource.config;

import com.gdp.mulitdatasource.datasource.DynamicDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(MyDataSourceProperties myDataSourceProperties){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        for(Map.Entry map:myDataSourceProperties.getDatasource().entrySet()){
            HikariDataSource hikariDataSource = new HikariDataSource((HikariConfig) map.getValue());
            targetDataSources.put(map.getKey(),hikariDataSource);
            if(map.getKey().equals("default")){
                dynamicDataSource.setDefaultTargetDataSource(hikariDataSource);
            }
        }
        dynamicDataSource.setTargetDataSources(targetDataSources);
        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }
}
