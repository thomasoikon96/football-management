package com.football.management.repository;

import com.football.management.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository <Player, Integer> {
}
