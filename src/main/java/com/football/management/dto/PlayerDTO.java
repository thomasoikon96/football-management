package com.football.management.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PlayerDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String position;
    private LocalDate dateOfBirth;

    private Integer teamId;
    private String teamName;
}
