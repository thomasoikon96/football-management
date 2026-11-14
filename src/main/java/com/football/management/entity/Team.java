package com.football.management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "team")
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_id")
    private Integer id;

    @Column(name = "v_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "n_country_id")
    private Country country;

    @Column(name = "dt_year_founded")
    private LocalDate yearFounded;
}
