package com.noriteo.delinori.notice.mapper;

import com.noriteo.delinori.notice.domain.Notice;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeMapper {
    void insert(Notice board);
}
