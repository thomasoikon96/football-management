package com.football.management.dto;

import lombok.Data;

@Data
public class PlayerDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String position;
    private Integer age;
    private Integer teamId;
    private String teamName;
}
