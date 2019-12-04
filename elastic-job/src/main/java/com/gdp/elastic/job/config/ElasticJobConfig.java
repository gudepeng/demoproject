package com.gdp.elastic.job.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticJobConfig {

    /**
     * 连接Zookeeper服务器的列表. 包括IP地址和端口号. 多个地址用逗号分隔. 如: host1:2181,host2:2181
     */
    @Value("${elasticjob.serverlists}")
    private String serverLists;

    /**
     * 命名空间.
     */
    @Value("${elasticjob.namespace}")
    private String namespace;

    /**
     * 等待重试的间隔时间的初始值. 单位毫秒.
     */
    private int baseSleepTimeMilliseconds;

    /**
     * 等待重试的间隔时间的最大值. 单位毫秒.
     */
    private int maxSleepTimeMilliseconds;

    /**
     * 最大重试次数.
     */
    private int maxRetries;

    /**
     * 登录权限
     */
    private String digest;

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter zookeeperRegistryCenter() {
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(serverLists, namespace);
//        zookeeperConfiguration.setMaxRetries(maxRetries);
////        zookeeperConfiguration.setBaseSleepTimeMilliseconds(baseSleepTimeMilliseconds);
////        zookeeperConfiguration.setMaxSleepTimeMilliseconds(maxSleepTimeMilliseconds);
////        zookeeperConfiguration.setDigest(digest);
        return new ZookeeperRegistryCenter(zookeeperConfiguration);
    }

}
