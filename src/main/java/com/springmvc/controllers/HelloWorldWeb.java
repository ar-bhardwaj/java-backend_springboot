package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldWeb {
    @GetMapping("/hi")
    public String hi(Model model) {
        model.addAttribute("message", "Hello From Anmol");
        return "hello";
    }

}
