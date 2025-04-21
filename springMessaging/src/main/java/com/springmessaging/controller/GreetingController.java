package com.springmessaging.controller;

import com.springmessaging.entities.GreetingEntities;
import com.springmessaging.service.GreetingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Autowired
    private GreetingServices greetingServices;

    //static GreetingEntities message

    @GetMapping("{id}")
    public ResponseEntity<GreetingEntities> getGreeting(@PathVariable long id) {
        return new ResponseEntity<>(greetingServices.findId(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<GreetingEntities> addGreet(
            @RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "lastName", defaultValue = "") String lastName
    ) {
        return new ResponseEntity<>(greetingServices.savegreet(firstName, lastName), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<GreetingEntities> editGreet(
            @PathVariable long id,
            @RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "lastName", defaultValue = "") String lastName
    ) {
        return new ResponseEntity<>(greetingServices.updateGreet(id, firstName, lastName), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteGreeting(@PathVariable long id) {
        if (greetingServices.deleteGreeting(id)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }


}

