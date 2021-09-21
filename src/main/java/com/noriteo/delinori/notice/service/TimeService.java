package com.noriteo.delinori.notice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface TimeService {

    String getNow();
}
