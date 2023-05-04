package com.study.helloworld.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITransaction3Dao {
    public void pay(String consumerId, int amount);
}
