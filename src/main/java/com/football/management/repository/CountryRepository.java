package com.football.management.repository;

import com.football.management.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository <Country, Integer> {
}
