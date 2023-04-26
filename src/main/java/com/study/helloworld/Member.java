package com.study.helloworld;

// 이런 형태를 '커맨드(command) 객체'라 지칭
// 스프링의 '데이터 트랜스퍼 오브젝트(DTO, Data Transfer Object)'와 유사
// DB 관련해서는 'DTO', 파라미터 관련해서는 '커맨드 객체'로 명칭 통일

// lombok : 자바 클래스 만들 때 흔히 만드는 코드들을 어노테이션을 이용해서 자동으로 만들어주는 유틸리티 라이브러리
// 흔히 만드는 코드들?? DTO와 같은 모델에서 항상 만들게 되는 getter, setter 메서드와 toString, equals, hashCode와 같은 메서드 의미.

import lombok.Data;

@Data
public class Member {
    private String id;
    private String name;
}
