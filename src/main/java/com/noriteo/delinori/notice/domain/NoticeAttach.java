package com.noriteo.delinori.notice.domain;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeAttach {

    private String uuid;
    public  Long bno;
    private String fileName;
    private String path;
    private boolean image;

    public void setBno(Long bno){ //DB랑 연결될 Entity가 필요해서 fk값인 bno를 뽑아주는 메서드
        this.bno = bno;
    }
}