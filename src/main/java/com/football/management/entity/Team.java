package com.football.management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "team")
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "year_founded")
    private Integer yearFounded;
}
