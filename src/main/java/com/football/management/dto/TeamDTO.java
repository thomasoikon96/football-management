package com.football.management.dto;

import lombok.Data;

@Data
public class TeamDTO {
    private Integer id;
    private String name;
    private String country;
    private Integer yearFounded;
}
