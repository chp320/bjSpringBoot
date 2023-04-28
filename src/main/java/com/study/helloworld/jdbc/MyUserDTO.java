package com.study.helloworld.jdbc;

/* 데이터베이스 테이블에서 SQL문의 쿼리로 발생하는 데이터를 처리하기 위한 것 -> 테이블의 컬럼명으로 변수 생성
   - 변수만 생성. 변수에 대한 getter, setter 생성x
   - 롬복 사용을 위한 @Data 어노테이션 추가
*/

import lombok.Data;

@Data
public class MyUserDTO {
    private String id;
    private String name;
}
