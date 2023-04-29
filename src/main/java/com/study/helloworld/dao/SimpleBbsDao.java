package com.study.helloworld.dao;

import com.study.helloworld.dto.SimpleBbsDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleBbsDao implements ISimpleBbsDao {

    /* 생성자 주입 start */
    private final JdbcTemplate jdbcTemplate;

    public SimpleBbsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /* 생성자 주입 end */

    @Override
    public List<SimpleBbsDto> listDao() {
        System.out.println("listDao() call!!");

        // 쿼리 작성
        String query = "select * from simple_bbs order by id desc";
        // 결과가 "여러 개"가 나오는 SQL문 처리 -> JdbcTemplate의 query 메서드 사용!!!
        List<SimpleBbsDto> dtos = jdbcTemplate.query(query, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));

        return dtos;
    }

    @Override
    public SimpleBbsDto viewDao(String id) {
        System.out.println("viewDao() call!!");

        // 쿼리 작성
        String query = "select * from simple_bbs where id = " + id;
        // 결과가 "하나"만 나오는 SQL문 처리 -> JdbcTemplate의 queryForObject 메서드 사용!!
        SimpleBbsDto dto = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));
        return dto;
    }

    @Override
    public int writeDao(String writer, String title, String content) {
        System.out.println("writeDao() call!!");

        // MySQL은 오라클과 달리 시퀀스가 없어서 별도 시퀀스 펑션을 만들었고, 기 정의된 'id_seq' 이름으로 전달된 경우 번호를 +1 채번한다. seq_name 전달을 위한 변수
        String seq = "id_seq";
        // 쿼리 작성
        String query = "insert into simple_bbs (id, writer, title, content) " +
                       "values ((select get_seq(?)), ?, ?, ?)";
        return jdbcTemplate.update(query, seq, writer, title, content);
    }

    @Override
    public int deleteDao(String id) {
        System.out.println("deleteDao() call!!");

        // 쿼리 작성
        String query = "delete from simple_bbs where id = ?";
        return jdbcTemplate.update(query, Integer.parseInt(id));
    }
}
