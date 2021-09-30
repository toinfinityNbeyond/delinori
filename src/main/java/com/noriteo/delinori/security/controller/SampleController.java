package com.noriteo.delinori.security.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/notice")
public class SampleController {

    @GetMapping("/doAll")
    public void doAll(){
        log.warn("doAll.........");
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/doNori")
    public void doNori(){
        log.warn("doNori....................");
    }

    //@PreAuthorize("isAuthenticated()")
    @GetMapping("/doDeli")
    public void doDeli(){
        log.warn("doDeli....................");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/doAdmin")
    public void doAdmin(){
        log.warn("doAdmin....................");
    }


    @GetMapping("/logout")
    public void logout() {
        log.info("logout 꺄오!!!!!!!!!!!!!!!!!!!!!!!!");

    }

}