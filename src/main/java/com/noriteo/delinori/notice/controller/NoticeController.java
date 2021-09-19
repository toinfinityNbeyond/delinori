package com.noriteo.delinori.notice.controller;

import com.noriteo.delinori.notice.dto.NoticeDTO;
import com.noriteo.delinori.notice.service.NoticeService;
import com.noriteo.delinori.notice.service.TimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice/*")
@Log4j2
@RequiredArgsConstructor
public class NoticeController {

    private final TimeService timeService;

    private final NoticeService noticeService;

    @GetMapping("/time")
    public void getTime(Model model){
        log.info("==========controller getTime=========");
        model.addAttribute("time", timeService.getNow());
    }

    @PostMapping("/register")
    public String registerPost(NoticeDTO noticeDTO){

        log.info("noticeDTOM      "   + noticeDTO);

        Long nno = noticeService.register(noticeDTO);

        return "redirect:/noriteo/list";

    }

}
