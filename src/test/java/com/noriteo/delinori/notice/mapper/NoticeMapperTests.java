package com.noriteo.delinori.notice.mapper;

import com.noriteo.delinori.common.config.RootConfig;
import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.common.dto.PageResponseDTO;
import com.noriteo.delinori.notice.config.NoticeRootConfig;
import com.noriteo.delinori.notice.domain.Notice;
import com.noriteo.delinori.notice.dto.NoticeDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {NoticeRootConfig.class, RootConfig.class})
public class NoticeMapperTests {

    @Autowired
    NoticeMapper noticeMapper;

    @Test
    public void testDummies(){

        IntStream.rangeClosed(1,100).forEach( i -> {
            //Long nno = null;
            Notice board = Notice.builder()
                   // .nno(nno + i)
                    .title("title" + i)
                    .writer("user" + (i % 10))
                    .content("content" + i)
                   // .regDate("regDate" + i)
                   // .modDate()
                    .build();

            noticeMapper.insert(board);

        });
    }

    @Test
    public void testList(){

        PageRequestDTO pageRequestDTO =
                PageRequestDTO.builder()
//                        .type("TC")
//                        .keyword("AA")
                        .build();

        log.info(pageRequestDTO);

        //boardMapper.getList(pageRequestDTO).forEach(board -> log.info(board));

        List<NoticeDTO> noticeDTOList = noticeMapper.getList(pageRequestDTO).stream().map(notice -> notice.getDTO()).collect(Collectors.toList());

      //  int count = noticeMapper.getCount(pageRequestDTO);

        PageResponseDTO<NoticeDTO> pageResponseDTO = PageResponseDTO.<NoticeDTO>builder()
                .dtoList(noticeDTOList)
      //          .count(count)
                .build();

    }

}
