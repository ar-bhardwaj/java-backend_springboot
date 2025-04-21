package com.springmessaging.service;

import com.springmessaging.entities.GreetingEntities;
import com.springmessaging.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingServices {

    private final GreetingRepository greetrepo;

    public GreetingServices(GreetingRepository greetrepo) {
        this.greetrepo = greetrepo;
    }
    public List<GreetingEntities> getGreets(){
        return greetrepo.findAll();
    }

    public GreetingEntities savegreet(String firstName, String lastName) {
        GreetingEntities greetentities = GreetingEntities.builder().message
                (("Hello "+firstName+" "+lastName).trim()).build();
        greetrepo.save(greetentities);
        return greetentities;

    }
    public GreetingEntities findId(Long id)  {
        return greetrepo.findById(id).get();
    }
}