package com.noriteo.delinori.notice.dto;

import com.noriteo.delinori.notice.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {

    private Long nno;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime redDate;
    private LocalDateTime modDate;

    public Board getDomain(){
        Board board = Board.builder()
                            .nno(nno)
                            .title(title)
                            .writer(writer)
                            .content(content)
                            .regDate(redDate)
                            .modDate(modDate)
                            .build();

        return board;
    }

}

