package com.football.management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "country")
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_id")
    private Integer id;

    @Column(name = "v_name", nullable = false)
    private String name;

}
