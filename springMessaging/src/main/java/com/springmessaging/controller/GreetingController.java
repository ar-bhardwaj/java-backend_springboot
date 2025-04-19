package com.springmessaging.controller;

import com.springmessaging.entities.GreetingEntities;
import com.springmessaging.service.GreetingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @Autowired
    private GreetingServices greetingServices;

    static GreetingEntities message;

    @GetMapping("/get")
    public GreetingEntities get() {
        return message;
    }

    @PostMapping("/post")
    public GreetingEntities post(@RequestParam String name) {
        GreetingEntities newMessage = new GreetingEntities(Long.parseLong("1"), greetingServices.greet(name));
        GreetingController.message=newMessage;
        return newMessage;
    }

//    @PutMapping("/put")
//    public String put(@RequestParam String message) {
//        GreetingController.message = message;
//        return message;



}
