package com.noriteo.delinori.notice.mapper;

import com.noriteo.delinori.notice.domain.Board;
import org.springframework.stereotype.Service;


public interface NoticeMapper {
    void insert(Board board);
}
