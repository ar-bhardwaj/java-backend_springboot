package com.springrest.controller;


import com.springrest.dtos.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestApiController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello Aditi";
    }
    @GetMapping("/query")
    public String query(@RequestParam String name) {
        return "Hello query " + name;
    }

    @GetMapping("/param/{name}")
    public String param(@PathVariable String name) {
        return "Hello param" + name;
    }
    @PostMapping("/post")
    public String post(@RequestBody UserDto userDTO) {
        return "Hello post " + userDTO.getFirstName() + " " + userDTO.getLastName();
    }

    @PutMapping("/put/{firstName}")
    public String put(@PathVariable String firstName, @RequestParam String lastName) {
        return "Hello put" + firstName + " " + lastName;
    }
}
