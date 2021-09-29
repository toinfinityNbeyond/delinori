package com.noriteo.delinori.notice.service;

import com.noriteo.delinori.notice.domain.Reply;
import com.noriteo.delinori.notice.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {

    int add(ReplyDTO replyDTO);

    List<ReplyDTO> getRepliesWithNno(Long nno);

    int remove(Long rno);

    int modify(ReplyDTO replyDTO);

    //List<Reply> getListWithPaging(Long nno);

    default Reply dtoToEntity (ReplyDTO dto) { //DTO -> Entity
        Reply reply = Reply.builder()
                .rno(dto.getRno())
                .nno(dto.getNno())
                .reply(dto.getReply())
                .replyer(dto.getReplyer())
                .replyDate(dto.getReplyDate())
                .modDate(dto.getModDate())
                .build();

        return  reply;
    }
    default ReplyDTO entityToDTO(Reply reply) {  //원래 인터페이스는 가질 수 없다. 자바 8부터 가능



        ReplyDTO replyDTO = ReplyDTO.builder()
                .rno(reply.getRno())
                .nno(reply.getNno())
                .reply(reply.getReply())
                .replyer(reply.getReplyer())
                .replyDate(reply.getReplyDate())
                .modDate(reply.getModDate() )
                .build();

        return replyDTO;

    }





}
