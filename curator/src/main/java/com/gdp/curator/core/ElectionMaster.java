package com.gdp.curator.core;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.EOFException;

public class ElectionMaster {

    @Autowired
    private ZookeeperService zookeeperService;

    private LeaderLatch leaderLatch;

    @PostConstruct
    public void initLatch(){
        try {
            CuratorFramework client = zookeeperService.getClient();
            String lockPath = "/leader";
            leaderLatch = new LeaderLatch(client,lockPath);
            LeaderLatchListener listener = new LeaderLatchListener() {
                @Override
                public void isLeader() {
                    System.out.println("i am master");
                }

                @Override
                public void notLeader() {
                    System.out.println("i am salver");
                }
            };
            leaderLatch.addListener(listener);
            leaderLatch.start();
            leaderLatch.await();
            while (true){
                System.out.println("for i am master");
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
