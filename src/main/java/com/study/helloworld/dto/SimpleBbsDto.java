package com.study.helloworld.dto;

/* 데이터베이스 테이블에서 SQL문의 쿼리로 발생하는 데이터를 처리하기 위한 클래스 -> 테이블의 컬럼명으로 변수 생성 (별도 getter, setter 생성x) */
/*
create table simple_bbs (
	id int primary key,
    writer varchar(100),
    title varchar(100),
    content varchar(100)
);
 */
import lombok.Data;

@Data
public class SimpleBbsDto {
    private int id;
    private String writer;
    private String title;
    private String content;
}
