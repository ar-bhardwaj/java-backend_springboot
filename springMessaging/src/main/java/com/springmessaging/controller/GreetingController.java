package com.springmessaging.controller;

import com.springmessaging.entities.GreetingEntities;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    static GreetingEntities message;
    @GetMapping("/get")
    public GreetingEntities get() {
        return message;
    }
    @PostMapping("/post")
    public GreetingEntities post(@RequestParam String msg) {
        GreetingEntities newMessage = new GreetingEntities(Long.parseLong("1"), msg);
        GreetingController.message=newMessage;
        return newMessage;
    }
//    @PutMapping("/put")
//    public String put(@RequestParam String message) {
//        GreetingController.message = message;
//        return message;
//    }
}
