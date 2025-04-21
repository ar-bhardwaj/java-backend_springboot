package com.springaddressbook.controller;

import com.springaddressbook.entities.UserEntity;
import com.springaddressbook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
        @Autowired
    private UserService us;

        @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody UserEntity user){
            return us.addUser(user);

        }

}
