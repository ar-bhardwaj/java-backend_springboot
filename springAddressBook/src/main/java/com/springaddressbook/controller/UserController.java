package com.springaddressbook.controller;

import com.springaddressbook.dto.UserDTO;
import com.springaddressbook.entities.UserEntity;
import com.springaddressbook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService us;
       private static final Logger log = Logger.getLogger(UserController.class.getName());

    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody UserDTO udto) {
        return us.addUser(udto);

    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?>view (@PathVariable Long id) {
        log.info("view user with id " + id);
        return us.viewUser(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> put (@PathVariable Long id, @RequestBody UserDTO udto){
        return us.editUser(id,udto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        return us.deleteUser(id);
    }


}
