package com.noriteo.delinori.notice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.noriteo.delinori.notice.domain.Reply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {

    private Long rno; //spring JPA(mybatis랑 비슷한데 요새 많이 쓰는 것) 에서는 래퍼 타입(래퍼런스 타입)Long이 기본값.JPA는 해외에서 많이 사용.
    private Long nno;
    private String replyer;
    private String reply;


    @JsonFormat(shape =  JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime replyDate;
    @JsonFormat(shape =  JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modDate;

}
