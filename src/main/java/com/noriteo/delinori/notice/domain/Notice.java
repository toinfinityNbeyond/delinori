package com.noriteo.delinori.notice.domain;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

    private Long nno;
    private String title,writer,content;
    private LocalDateTime regDate,modDate;
}
