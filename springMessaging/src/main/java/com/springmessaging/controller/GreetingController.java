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

    static GreetingEntities message;

        @GetMapping("{id}")
        public ResponseEntity<GreetingEntities> getbyId(@PathVariable Long id) {
            return new ResponseEntity<>(greetingServices.findId(id),HttpStatus.OK);
        }



//    @GetMapping("/simple")
//    public ResponseEntity<GreetingEntities> simplegreeting(){
//        return new ResponseEntity<>(greetingServices.simpleGreet(),HttpStatus.OK );
//    }

//    @GetMapping()
//        public ResponseEntity<List<GreetingEntities>>getGreeting()
//        {
//            return new ResponseEntity<>(greetingServices.getGreets(),HttpStatus.OK);
//        }

        @PostMapping()
        public ResponseEntity<GreetingEntities>postGreeting(
                @RequestParam(value="firstName",defaultValue="")String firstName,
                @RequestParam(value="lastName",defaultValue = "")String lastName
        )
        {
            return new ResponseEntity<>(greetingServices.savegreet(firstName,lastName),HttpStatus.OK);
        }

    }

//    @PostMapping("/post")
//    public GreetingEntities post(@RequestParam String name) {
//        GreetingEntities newMessage = new GreetingEntities("Hello");
//        GreetingController.message=newMessage;
//        return newMessage;
//    }

//    @PutMapping("/put")
//    public String put(@RequestParam String message) {
//        GreetingController.message = message;
//        return message;





