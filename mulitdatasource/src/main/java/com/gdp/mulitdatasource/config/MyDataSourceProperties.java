package com.gdp.mulitdatasource.config;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "spring")
public class MyDataSourceProperties {

    private Map<String, HikariConfig> datasource = new HashMap<>();


    public Map<String, HikariConfig> getDatasource() {
        return datasource;
    }

    public void setDatasource(Map<String, HikariConfig> datasource) {
        this.datasource = datasource;
    }
}
