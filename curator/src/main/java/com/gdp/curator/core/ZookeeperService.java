package com.gdp.curator.core;

import com.gdp.curator.config.ZkConfig;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ZookeeperService {
    @Autowired
    private ZkConfig zkConfig;

    private CuratorFramework client;

    @PostConstruct
    public void init(){
        RetryPolicy retryPolicy  = new ExponentialBackoffRetry(zkConfig.getBaseSleepTimeMs(),zkConfig.getMaxRetries());
        this.client = CuratorFrameworkFactory.builder()
                .connectString(zkConfig.getServer())
                .retryPolicy(retryPolicy)
                .namespace(zkConfig.getNamespace())
                .build();
        this.client.start();
    }

    public CuratorFramework getClient(){
        return this.client;
    }


}
