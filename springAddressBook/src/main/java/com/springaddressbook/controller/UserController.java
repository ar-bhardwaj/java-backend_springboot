package com.springaddressbook.controller;

import com.springaddressbook.entities.UserEntity;
import com.springaddressbook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
        @Autowired
    private UserService us;

        @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody UserEntity user){
            return us.addUser(user);

        }

        @GetMapping("/view/{id}")
    public ResponseEntity<?>view (@PathVariable Long id){
            return us.viewUser(id);
        }

        @PutMapping("/put/{id}")
    public ResponseEntity<String> put (@PathVariable Long id, @RequestBody UserEntity user){
            return us.editUser(id,user);
        }

        @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id, @RequestBody UserEntity user){
            return us.deleteUser(id,user);
        }


}
