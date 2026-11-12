package com.football.management.repository;

import com.football.management.entity.Player;
import com.football.management.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository <Team, Integer> {
}
