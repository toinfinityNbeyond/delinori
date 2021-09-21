package com.noriteo.delinori.notice.controller;

import com.noriteo.delinori.common.dto.PageMaker;
import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.common.dto.PageResponseDTO;
import com.noriteo.delinori.notice.dto.NoticeDTO;
import com.noriteo.delinori.notice.service.NoticeService;
import com.noriteo.delinori.notice.service.TimeService;
import lombok.Getter;
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



    @GetMapping("/list")
    public void getList(PageRequestDTO pageRequestDTO, Model model){
        //jsp로 담아서 보내줘야 한다. -> model사용(담아서 사용할 떄는 model)
        log.info("c         getList........................................." + pageRequestDTO);//c : controller

        PageResponseDTO<NoticeDTO> responseDTO = noticeService.getDTOList(pageRequestDTO);

        //기본형의 경우 model 을 사용하지 않아도 자동으로 전달됨.
        model.addAttribute("dtoList", responseDTO.getDtoList()); //boardList.jsp를 찾아감

        int total = responseDTO.getCount();
        int page = pageRequestDTO.getPage();
        int size = pageRequestDTO.getSize();   // 세개 있으면 페이지 메이커를 만들 수 있다

        model.addAttribute("pageMaker", new PageMaker(page,size,total));   // 필요한거 전달


        //model.addAttribute("pageMaker", new PageMaker(pageRequestDTO.getPage();,size,total));  이런식으로 줄이는것도 가능
    }  // 페이지와 사이즈를 파라미터로 던진다.

}



