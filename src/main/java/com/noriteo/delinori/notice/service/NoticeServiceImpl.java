package com.noriteo.delinori.notice.service;

import com.noriteo.delinori.notice.domain.Board;
import com.noriteo.delinori.notice.dto.NoticeDTO;
import com.noriteo.delinori.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeMapper noticeMapper;

    @Override
    public Long register(NoticeDTO noticeDTO) {
        Board board = noticeDTO.getDomain();

        noticeMapper.insert(board);

        return board.getNno();
    }
}
