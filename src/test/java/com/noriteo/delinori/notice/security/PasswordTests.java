package com.noriteo.delinori.notice.security;


import com.noriteo.delinori.common.config.RootConfig;
import com.noriteo.delinori.notice.config.NoticeRootConfig;
import com.noriteo.delinori.security.config.SecurityConfig;
import com.noriteo.delinori.security.domain.Member;
import com.noriteo.delinori.security.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = {RootConfig.class, SecurityConfig.class})
public class PasswordTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired(required = false)
    MemberMapper memberMapper;

    @Test
    public void testDeli(){
        String mid = "admin101";

        Member member = memberMapper.findById(mid);

        log.warn("-------------------------");
        log.warn(member);
    }


    @Test
    public void testEncode(){
        String str ="deli1";
        String enStr = passwordEncoder.encode(str);
        log.warn(enStr);
    }

    @Test
    public void testDecode(){
        String str = "$2a$10$aPY61JHKza0jGC9jl4oTfu3nzFPvwQIbC8j5T9zDKSiCSSUFVHmMC";

        boolean match = passwordEncoder.matches("deli1",str);

        log.warn(match);
    }

    @Test
    public void insertDeli(){
        //insert into tbl_member (id,pw,name) values ('id','pw','name');


        String query = "insert into tbl_member (mid,pw,name) values ('v1','v2','v3');";

        for(int i = 0; i < 10; i++) {

            String id = "deli" + i;
            String pw = passwordEncoder.encode("pw" + i);
            String name = "딜리" + i;

            String result = query;

            result = result.replace("v1", id);
            result = result.replace("v2", pw);
            result = result.replace("v3", name);

            System.out.println(result);
        }
    }


    @Test
    public void insertAdmin(){
        //insert into tbl_member (id,pw,name) values ('id','pw','name');


        String query = "insert into tbl_member (mid,pw,name) values ('v1','v2','v3');";

        for(int i = 100; i < 110; i++) {

            String id = "admin" + i;
            String pw = passwordEncoder.encode("pw" + i);
            String name = "관리자" + i;

            String result = query;

            result = result.replace("v1", id);
            result = result.replace("v2", pw);
            result = result.replace("v3", name);

            System.out.println(result);
        }
    }


    @Test
    public void insertMemberRole(){

        String sql = "insert into member_role (mid,role) values ('%s','%s');";

        for(int i = 0; i < 10; i++) {
            String result = String.format(sql, "deli"+i, "ROLE_DELI");

            System.out.println(result);

        }
    }


    @Test
    public void insertAdminRole(){

        String sql = "insert into member_role (mid,role) values ('%s','%s');";

        for(int i = 0; i < 10; i++) {

            String result2 = String.format(sql, "admin"+i, "ROLE_ADMIN");

            System.out.println(result2);

        }
    }




}
