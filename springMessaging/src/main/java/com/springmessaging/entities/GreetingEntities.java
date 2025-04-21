package com.springmessaging.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GreetingEntities {
    @Id
    @GeneratedValue
    private Long id;
    private String message;

//    GreetingEntities(String message, Long id) {
//        this.message = message;
//        this.id = id;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

}
