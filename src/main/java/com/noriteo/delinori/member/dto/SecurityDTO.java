package com.noriteo.delinori.member.dto;

import com.noriteo.delinori.member.domain.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.stream.Collectors;

@Getter
@Setter
public class SecurityDTO extends User {

    private String mid;
    private String mname;
    private String mpw;
    private String maddress;
    private String memail;
    private String mphone;
    private boolean enable;
    private boolean delifile;

    public SecurityDTO(Member member){
        super(member.getMid(), member.getMpw(), member.getRoleList().stream()
                .map(memberRole ->
                        new SimpleGrantedAuthority(memberRole.getRole())).collect(Collectors.toList()));

        this.mid=member.getMid();
        this.mpw=member.getMpw();
        this.mname=member.getMname();
        this.maddress=member.getMaddress();
        this.memail=member.getMemail();
        this.mphone=member.getMphone();
        this.enable=member.isEnable();
        this.delifile=member.isDelifile();
    }

}
