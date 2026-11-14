package com.football.management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "player")
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_id")
    private Integer id;

    @Column(name = "v_firstname", nullable = false)
    private String firstName;

    @Column(name = "v_lastname", nullable = false)
    private String lastName;

    @Column (name = "v_position")
    private String position;

    @Column(name = "dt_date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "n_team_id")
    private Team team;
}
