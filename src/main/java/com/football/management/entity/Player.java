package com.football.management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "player")
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column (name = "position")
    private String position;

    @Column(name = "age", nullable = false)
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
