package com.noriteo.delinori.security.domain;


import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {

    private String mid;
    private String pw;
    private String name;
    private boolean enabled;

    private List<MemberRole> roleList;

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

}