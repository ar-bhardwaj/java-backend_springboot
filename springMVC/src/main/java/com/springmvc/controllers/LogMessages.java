package com.springmvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogMessages {
    private static final Logger log = LoggerFactory.getLogger(LogMessages.class);

    @GetMapping("/log")
    public String hello() {
        log.info( "handling rest request to \"/rest\"" );
        return "Hello World From Aditi!";

    }

}
