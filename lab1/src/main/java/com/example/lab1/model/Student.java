package com.example.lab1.model;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public @Data
class Student {
    private Long id;
    private String ma;
    private String hoTen;
    private LocalDate dob;
}
