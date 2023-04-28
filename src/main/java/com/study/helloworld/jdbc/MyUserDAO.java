package com.study.helloworld.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 빈.으로 등록 (이 클래스를 빈.으로 등록할껀데 데이터베이스와 관련된 처리 용도로 사용할꺼임)
public class MyUserDAO {
    /* 아래 주석은 field injection 방법으로, 스프링 컨테이너 외에 외부에서 주입불가하므로 생성자 주입 방식으로 대체 -> 실제 IDE에서 field injection을 추천하지 않음 */
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    /* 생성자 주입 방법 사용 start */
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MyUserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /* 생성자 주입 방법 사용 end */

    public List<MyUserDTO> list() {
        String query = "select * from myuser";
        List<MyUserDTO> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<MyUserDTO>(MyUserDTO.class));    // query() 메서드는 query를 실행. 쿼리 결과를 result-set의 row마다 DTO 객체로 받겠다는 의미.

        for (MyUserDTO my : list) {
            System.out.println(my.toString());
        }

        return list;
    }
}
