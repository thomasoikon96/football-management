package com.football.management.service;

import com.football.management.dto.PlayerDTO;
import com.football.management.entity.Player;
import com.football.management.repository.PlayerRepository;
import com.football.management.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    public List <PlayerDTO> getAllPlayers() {
        List <Player> players = playerRepository.findAll();
        List <PlayerDTO> playerDTOS = new ArrayList<>();

        for (Player player : players){
            PlayerDTO dto = new PlayerDTO();
            dto.setId(player.getId());
            dto.setFirstName(player.getFirstName());
            dto.setLastName(player.getLastName());
            dto.setPosition(player.getPosition());
            dto.setAge(player.getAge());

            if(player.getTeam() != null) {
                dto.setTeamId(player.getTeam().getId());
                dto.setTeamName(player.getTeam().getName());
            }

            playerDTOS.add(dto);
        }

        return playerDTOS;
    }
}
