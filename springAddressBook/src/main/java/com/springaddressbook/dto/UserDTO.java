package com.springaddressbook.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String city;
    @NotBlank
    private String phone;
    private String address;

}
