package com.noriteo.delinori.notice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.noriteo.delinori.notice.mapper")
@ComponentScan(basePackages = "com.noriteo.delinori.notice.service")
public class NoticeRootConfig {


}
