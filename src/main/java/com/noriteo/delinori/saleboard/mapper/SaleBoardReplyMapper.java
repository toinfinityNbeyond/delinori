package com.noriteo.delinori.saleboard.mapper;

import com.noriteo.delinori.saleboard.domain.Reply;

import java.util.List;

public interface SaleBoardReplyMapper {

    int insert(Reply reply);

    int replyUpdate(Reply reply);

    List<Reply> getListWithBoard(Long sno);

    int delete(Long rno);

    int update(Reply reply);

}
