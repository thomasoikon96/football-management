package com.football.management.dto;

import lombok.Data;

@Data
public class TeamDTO {
    private Integer id;
    private String name;
    private CountryDTO country;
    private Integer yearFounded;
}
