package com.noriteo.delinori.notice.service;

import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.common.dto.PageResponseDTO;
import com.noriteo.delinori.notice.domain.Notice;
import com.noriteo.delinori.notice.dto.NoticeDTO;
import com.noriteo.delinori.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeMapper noticeMapper;

    @Override
    public Long register(NoticeDTO noticeDTO) {
        Notice notice = noticeDTO.getDomain();

        noticeMapper.insert(notice);

        return notice.getNno();
    }

    @Override
    public PageResponseDTO<NoticeDTO> getDTOList(PageRequestDTO pageRequestDTO) {

        List<NoticeDTO> dtoList = noticeMapper.getList(pageRequestDTO).stream().map(notice -> notice.getDTO()).collect(Collectors.toList());
        int count = noticeMapper.getCount(pageRequestDTO);

        PageResponseDTO <NoticeDTO> pageResponseDTO = PageResponseDTO.<NoticeDTO>builder()
                .dtoList(dtoList)
                .count(count)
                .build();


        return pageResponseDTO;
    }

    @Override
    public boolean remove(Long nno) {return noticeMapper.delete(nno) > 0;}
}
