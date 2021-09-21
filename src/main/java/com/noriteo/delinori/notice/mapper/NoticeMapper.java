package com.noriteo.delinori.notice.mapper;

import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.notice.domain.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface NoticeMapper {

    void insert(Notice notice);

    List<Notice> getList(PageRequestDTO pageRequestDTO);

    //int getCount(PageRequestDTO pageRequestDTO);

}
