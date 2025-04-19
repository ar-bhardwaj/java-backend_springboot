package com.springmessaging.service;

import com.springmessaging.entities.GreetingEntities;
import org.springframework.stereotype.Service;

@Service
public class GreetingServices {

    public  GreetingEntities simpleGreet (){
        return new GreetingEntities("hi Aditi");
    }

    public GreetingEntities nameGreet (String firstName, String lastName){
        return new GreetingEntities("Hello "+firstName+" "+lastName.trim());
    }
}
