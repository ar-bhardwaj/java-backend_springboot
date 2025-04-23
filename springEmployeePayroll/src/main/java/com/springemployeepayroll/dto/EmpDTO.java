package com.springemployeepayroll.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.processing.Pattern;

@Getter
@Setter
public class EmpDTO {

    private Long id;
    @NotBlank(message = "First letter should be in Capital Letter")
    // @Pattern(regex = "^[A-Z]{1}[A-Za-z]{2,}$",message="name must be valid")
    private String name;
    private double salary;
}
