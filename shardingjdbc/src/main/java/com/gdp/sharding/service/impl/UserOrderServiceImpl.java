package com.gdp.sharding.service.impl;

import com.gdp.sharding.service.UserOrderService;
import com.gdp.sharding.entity.UserOrder;
import com.gdp.sharding.service.impl.dao.UserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public int addUserOrder(UserOrder userOrder) {
        return userOrderMapper.addUserOrder(userOrder);
    }

}
