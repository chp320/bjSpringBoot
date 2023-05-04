package com.study.helloworld.service;

import com.study.helloworld.dao.ITransaction3Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogWriteService {

    @Autowired
    ITransaction3Dao transaction3Dao;

    public int write(String consumerId, int amount) {

        try {
            transaction3Dao.pay(consumerId, amount);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
