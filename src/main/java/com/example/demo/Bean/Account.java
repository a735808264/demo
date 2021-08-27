package com.example.demo.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
