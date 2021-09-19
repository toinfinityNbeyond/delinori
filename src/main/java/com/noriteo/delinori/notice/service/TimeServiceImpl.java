package com.noriteo.delinori.notice.service;

import com.noriteo.delinori.notice.mapper.TimeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService {

    private final TimeMapper timeMapper;

   @Override
   public String getNow(){

       log.info("service.........getNow()");


       return timeMapper.getTime2();
   }

}
