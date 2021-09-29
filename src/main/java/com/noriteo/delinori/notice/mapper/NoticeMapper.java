package com.noriteo.delinori.notice.mapper;

import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.notice.domain.Notice;
import com.noriteo.delinori.notice.domain.NoticeAttach;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface NoticeMapper {

    void insert(Notice notice);

    List<Notice> getList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);

    Notice select(Long nno);

    int delete(Long nno);

    int updateReplyCnt(@Param("nno") Long nno, @Param("num") int num); // 안됨 mybatis는 기본적으로 파라미터 값이 하나만 가능. 댓글이 추가되면 +1 , 삭제되면 -1
    //첫번째 - map , 두번째 DTO 세번째 param 어노테이션을 이용해서 처리
    //동시에 여러 파라미터 전달 가능


    int insertAttach(NoticeAttach attach);

    int deleteAttach(Long nno);

}
