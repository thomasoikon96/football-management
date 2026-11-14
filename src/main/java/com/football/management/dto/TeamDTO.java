package com.football.management.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TeamDTO {
    private Integer id;
    private String name;
    private CountryDTO country;
    private LocalDate yearFounded;
}
