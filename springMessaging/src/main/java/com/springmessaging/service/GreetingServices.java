package com.springmessaging.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServices {
    public String greet(String name) {
        return "Hii " + name + "!";
    }

}
