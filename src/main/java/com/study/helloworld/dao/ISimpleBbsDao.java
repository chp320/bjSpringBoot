package com.study.helloworld.dao;

import com.study.helloworld.dto.SimpleBbsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper // 다음 인터페이스의 구현을 XML로 한다는 의미.
public interface ISimpleBbsDao {

    /* select Method */
    public List<SimpleBbsDto> listDao();

    /* select Method */
    public SimpleBbsDto viewDao(String id);

    /* insert Method */
    public int writeDao(String writer, String title, String content);

    /* delete Method */
//    public int deleteDao(String id);
    /* @Param 어노테이션 사용한 파라미터 추가 */
    public int deleteDao(@Param("_id") String id); /* mapper에서도 파라미터명으로 지정한 값으로 수정 필요! */
}
