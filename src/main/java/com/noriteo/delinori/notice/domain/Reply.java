package com.noriteo.delinori.notice.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply {

    private Long rno; //Lnog이 기본값
    private Long nno;
    private String replyer;
    private String reply;
    private LocalDateTime replyDate;
    private LocalDateTime modDate;


}
