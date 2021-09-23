package com.noriteo.delinori.notice.service;


import com.noriteo.delinori.common.config.RootConfig;
import com.noriteo.delinori.notice.config.NoticeRootConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = {NoticeRootConfig.class, RootConfig.class})
public class TimeServiceTests {

    @Autowired
    TimeService timeService;

    @Test
    public void testAdd() {

        String str =  "Go down\n" +
                "Soft sound\n" +
                "Midnight\n" +
                "Car lights\n" +
                "Playing with the air\n" +
                "Breathing in your hair\n" +
                "Go down\n" +
                "Soft sound\n";

        timeService.addString(str);


    }
}
