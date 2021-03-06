package com.noriteo.delinori.qna.domain;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QnaAttach {
    private String uuid;
    private Long qno;
    private String fileName;
    private String path;
    private boolean image;

    public void setQno(Long qno) {
        this.qno = qno;
    }
}
