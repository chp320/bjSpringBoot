package com.study.helloworld.service;

import com.study.helloworld.dao.ITransaction1Dao;
import com.study.helloworld.dao.ITransaction2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyTicketService implements IBuyTicketService {
    @Autowired
    ITransaction1Dao transaction1Dao;
    @Autowired
    ITransaction2Dao transaction2Dao;

    @Override
    public int buy(String consumerId, int money, String error) {

        try {
            transaction1Dao.pay(consumerId, money);

            // 의도적 에러 발생
            if(error.equals("1")) { int n = 10 / 0 ; }

            transaction2Dao.pay(consumerId, money);

            /* transaction1Dao 정상 수행 후, 에러 발생한 경우 transaction2Dao 는 오류가 나는데.. 이게 맞는걸까? 둘 다 정상 수행되어야 커밋되어야 하는게 아닐까?? */

            return 1;
        } catch (Exception e) {
            return 0;
        }

    }
}
