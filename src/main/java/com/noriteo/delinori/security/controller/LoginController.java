package com.noriteo.delinori.security.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
public class LoginController {

    @GetMapping("/customLogin")
    public void loginCustom(){
        log.warn("custom login...get");
    }


    @GetMapping("/customLogout")
    public void logoutGet(){

        log.info("custom logout");

    }



//    @RequestMapping(value = "logout", method = RequestMethod.POST)
//    public String logout(HttpServletRequest request) throws Exception{
//        log.info("logout 꺄오");
//
//        HttpSession session = request.getSession();
//
//        session.invalidate();
//
//        return "redirect:/notice/list";
//    }

}
