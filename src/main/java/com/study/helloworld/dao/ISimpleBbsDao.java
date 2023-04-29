package com.study.helloworld.dao;

import com.study.helloworld.dto.SimpleBbsDto;

import java.util.List;

public interface ISimpleBbsDao {

    /* select Method */
    public List<SimpleBbsDto> listDao();

    /* select Method */
    public SimpleBbsDto viewDao(String id);

    /* insert Method */
    public int writeDao(String writer, String title, String content);

    /* delete Method */
    public int deleteDao(String id);
}
