package com.noriteo.delinori.notice.dto;

import com.noriteo.delinori.notice.domain.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Notice getDomain(){
        Notice notice = Notice.builder()
                            .nno(nno)
                            .title(title)
                            .writer(writer)
                            .content(content)
                            .regDate(redDate)
                            .modDate(modDate)
                            .build();

        return notice;
    }

}

