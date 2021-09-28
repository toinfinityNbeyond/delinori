package com.noriteo.delinori.security.dto;

import com.noriteo.delinori.security.domain.Member;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
public class MemberDTO extends User {


    private String mid;
    private String pw;
    private String name;
    private boolean enabled;

    public MemberDTO(Member member){
        super(member.getMid(),
                member.getPw(),
                member.getRoleList().stream()                                               //권한 정보
                        .map(memberRole -> new SimpleGrantedAuthority(memberRole.getRole())).collect(Collectors.toList())); //memberRole을 GrantedAuthority으로 바꿔줘야함

        // 멤버를 넣어주면 멤버DTO가 나가게끔 만든다. 생성자 때문에 타입을 바꿔준다(타입 컨버팅)
        this.mid = member.getMid();
        this.pw = member.getPw();
        this.name = member.getName();
        this.enabled = member.isEnabled();

    }

    public MemberDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
