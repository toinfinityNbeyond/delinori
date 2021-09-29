package com.noriteo.delinori.notice.service;

import com.noriteo.delinori.notice.dto.ReplyDTO;
import com.noriteo.delinori.notice.mapper.NoticeMapper;
import com.noriteo.delinori.notice.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper;
    private final NoticeMapper noticeMapper;

    public int add(ReplyDTO replyDTO){
        int count = replyMapper.insert(dtoToEntity(replyDTO));
        noticeMapper.updateReplyCnt(replyDTO.getNno(),1);
        return count;

    }


    @Override
    public List<ReplyDTO> getRepliesWithNno(Long nno) {
        return replyMapper.getListWithNotice(nno).stream()
                .map(reply -> entityToDTO(reply)).collect(Collectors.toList());
    }

    @Override
    public int remove(Long rno) {

        return replyMapper.delete(rno);
    }

    @Override
    public int modify(ReplyDTO replyDTO) {
        return replyMapper.update(dtoToEntity(replyDTO)); //replyDTO 를 Entity
    }





}
