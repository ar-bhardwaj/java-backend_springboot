package com.springaddressbook.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserEntity {
    @Id

    private long id;

    private String name;
    private String city;
    private String phone;
    private String address;

}
