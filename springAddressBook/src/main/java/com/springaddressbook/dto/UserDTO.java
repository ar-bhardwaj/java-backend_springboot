package com.springaddressbook.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String city;
    private String phone;
    private String address;

}
