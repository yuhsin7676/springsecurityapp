package com.example.springsecurity.model;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Developer {
    private Long id;
    private String firstName;
    private String lastName;
}
