package com.noriteo.delinori.notice.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeMapper {

    @Select("select now()")
    String getTime();

    String getTime2();


    //void insertE1(String str);
}
