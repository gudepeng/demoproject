package com.gdp.curator.core;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;

@Component
public class ElectionMaster2 {

    @Autowired
    private ZookeeperService zookeeperService;

    private LeaderSelector leaderSelector;

    @PostConstruct
    public void initLatch(){
        try {
            CuratorFramework client = zookeeperService.getClient();
            String lockPath = "/leader";
            leaderSelector = new LeaderSelector(client,lockPath,new LeaderSelectorListenerAdapter(){
                @Override
                public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
                    for(int i = 0;i < 5;i++){
                        System.out.println("i am master"+i);
                        Thread.sleep(1000);
                    }
                }
            });
            leaderSelector.autoRequeue();
            leaderSelector.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
