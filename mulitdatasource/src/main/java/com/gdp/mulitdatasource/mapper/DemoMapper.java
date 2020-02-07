package com.gdp.mulitdatasource.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper {

    @Insert("insert into demo (id,name) values ( 1,'demo')")
    public int insertSql();
}
