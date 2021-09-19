package com.noriteo.delinori.notice.service;

import com.noriteo.delinori.notice.domain.Board;
import com.noriteo.delinori.notice.dto.NoticeDTO;

public interface NoticeService {

    Long register(NoticeDTO noticeDTO);
}
