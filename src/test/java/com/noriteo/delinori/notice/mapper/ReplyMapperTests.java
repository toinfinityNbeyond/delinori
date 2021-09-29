package com.noriteo.delinori.notice.mapper;


import com.noriteo.delinori.common.config.RootConfig;
import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.common.dto.PageResponseDTO;
import com.noriteo.delinori.notice.config.NoticeRootConfig;
import com.noriteo.delinori.notice.domain.Reply;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;
import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class) // 해당코드가 스프링을 실행한다고 알려줌
@ContextConfiguration( classes = {NoticeRootConfig.class, RootConfig.class}) //지정 된 클래스나 문자열을 이용해서 필요한 객체를 등록 (Spring의 Bean으로 등록된다.)
public class ReplyMapperTests {

    @Autowired(required = false) //스프링이 로딩할 때 Autowired 이 가능한지 체크하지 않는다.
    // 의존객체를 주입받지 못하면 에러가 난다 (false 로 해놨기 때문에 로딩 할 때 체크하지 않는다.기본값은 true)-> 객체에 주입 받지 못하더라도 빈을 생성.

    ReplyMapper replyMapper;  // 스프링의 configration 작동 ㄴㄴ

     @Test
    public void insertDummies() {

        long[] arr = {462L, 463L, 464L, 465L, 466L};  //nno

         IntStream.rangeClosed(1,5).forEach(num -> {   //IntStream는 루프로 생각

             long nno = arr[  ((int)(Math.random() * 1000)) % 5 ]; // 0 ~ 0.999 math.ramdom

             Reply reply = Reply.builder()
                                 .nno(nno)
                                 .reply("댓글...." + num)
                                 .replyer("user" + (num % 10))
                                 .build();


             replyMapper.insert(reply);

         });

     }

        @Test
        public void testList() {
            long nno = 230L;

            replyMapper.getListWithNotice(nno).forEach(reply -> log.info(reply));
        }

        @Test
        public void testList2() {

            PageRequestDTO page = new PageRequestDTO();

            List<Reply> replies = replyMapper.getListWithPaging(560L);


            replies.forEach(reply -> log.info(reply));



        }

}
