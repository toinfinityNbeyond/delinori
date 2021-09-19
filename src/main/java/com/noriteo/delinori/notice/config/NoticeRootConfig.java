package com.noriteo.delinori.notice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.noriteo.delinori.notice.mapper")
public class NoticeRootConfig {


}
