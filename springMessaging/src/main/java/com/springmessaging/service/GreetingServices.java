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

    public GreetingEntities getsimplegreet() {
        return GreetingEntities.builder().message("Hello World!").build();
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

    public GreetingEntities updateGreet(long id, String firstName, String lastName) {
        if (!greetrepo.existsById(id)) {
            return null;
        }
        GreetingEntities greeting = GreetingEntities.builder().message(("Hello " + firstName + " " + lastName).trim()).build();
        greeting.setId(id);
        greetrepo.save(greeting);
        return greeting;
    }

    public boolean deleteGreeting(long id) {
        if (!greetrepo.existsById(id)) {
            return false;
        }
        greetrepo.deleteById(id);
        greetrepo.flush();
        return !greetrepo.existsById(id);
    }
}
