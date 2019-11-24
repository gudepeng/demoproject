package com.gdp.sharding.service.impl.dao;

import com.gdp.sharding.entity.UserOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserOrderMapper {
    @Insert("insert into userorder (id,name,month) values (#{id},#{name},#{month})")
    int addUserOrder(UserOrder userOrder);
}
