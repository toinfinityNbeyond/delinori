package com.noriteo.delinori.notice.mapper;


import com.noriteo.delinori.notice.domain.Reply;

import java.util.List;

public interface ReplyMapper {

    int insert(Reply reply); //몇 개가 변경됬는지 알려준다

    List<Reply> getListWithNotice(Long nno);

    int delete(long rno);

    int update(Reply reply);

}
