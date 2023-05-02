package com.study.helloworld.service;

import com.study.helloworld.dao.ISimpleBbsDao;
import com.study.helloworld.dto.SimpleBbsDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service    // 이 클래스를 '빈'으로 사용하겠다는 의미
public class SimpleBbsService implements ISimpleBbsService {

    /* 생성자 주입 start */
    private final ISimpleBbsDao dao;

    public SimpleBbsService(ISimpleBbsDao dao) {
        this.dao = dao;
    }
    /* 생성자 주입 end */

    @Override
    public List<SimpleBbsDto> list() {
        return dao.listDao();
    }

    @Override
    public SimpleBbsDto view(String id) {
        return dao.viewDao(id);
    }

    @Override
    public int write(Map<String, String> map) {
        int nResult = dao.writeDao(map);
        return nResult;
    }

    @Override
    public int delete(String id) {
        int nResult = dao.deleteDao(id);
        return nResult;
    }

    @Override
    public int count() {
        int nTotalCount = dao.articleCount();
        return nTotalCount;
    }
}
