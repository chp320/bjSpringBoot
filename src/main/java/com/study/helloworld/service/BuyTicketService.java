package com.study.helloworld.service;

import com.study.helloworld.dao.ITransaction1Dao;
import com.study.helloworld.dao.ITransaction2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
//public class BuyTicketService implements IBuyTicketService {
public class BuyTicketService {
    @Autowired
    ITransaction1Dao transaction1Dao;
    @Autowired
    ITransaction2Dao transaction2Dao;

    /* 스프링 TransactionTemplate 사용하기 위한 자동 주입 */
    @Autowired
    TransactionTemplate transactionTemplate;

//    @Transactional(propagation = Propagation.REQUIRED)
    @Transactional(propagation = Propagation.REQUIRES_NEW)  // 각각의 트랜잭션을 별도 처리하겠다!
    public int buy(String consumerId, int money, String error) {

        /* TransactionTemplate 기능 구현 */
        try {
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus status) {
                    transaction1Dao.pay(consumerId, money);

                    // 의도적 에러 발생
                    if (error.equals("1")) {
                        int n = 10 / 0;
                    }

                    transaction2Dao.pay(consumerId, money);
                }
            });
            return 1;
        } catch (Exception e) {
            System.out.println("[Transaction Propagation #2] Rollback");
            return 0;
        }

    }
}
