package com.study.helloworld.jdbc;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper     // 다음 인터페이스의 구현을 'XML'로 한다는 의미. 인터페이스 구현을 자바가 아닌 xml로 sql만 만듦.
public interface IMyUserDao {
    List<MyUserDTO> list();
}
