package com.gdp.sharding.controller;

import com.gdp.sharding.service.UserOrderService;
import com.gdp.sharding.entity.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOrderController {
    @Autowired
    private UserOrderService shardingService;

    public void addUserOrder(){
        for(int i = 0 ;i<20 ; i++){
            UserOrder userOrder = new UserOrder();
            userOrder.setName("gdptest"+i);
            userOrder.setMonth((int) (Math.random() * 12 + 1));
            shardingService.addUserOrder(userOrder);
        }
    }
}
