package com.gdp.mulitdatasource.config;

import com.zaxxer.hikari.HikariConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "spring")
@Data
public class MyDataSourceProperties {

    private Map<String, HikariConfig> datasource = new HashMap<>();

}
