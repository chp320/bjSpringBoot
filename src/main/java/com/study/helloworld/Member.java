package com.study.helloworld;

// 이런 형태를 '커맨드(command) 객체'라 지칭
// 스프링의 '데이터 트랜스퍼 오브젝트(DTO, Data Transfer Object)'와 유사
// DB 관련해서는 'DTO', 파라미터 관련해서는 '커맨드 객체'로 명칭 통일

public class Member {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
