package com.football.management.service;

import com.football.management.dto.PlayerDTO;
import com.football.management.entity.Player;
import com.football.management.entity.Team;
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

    //GET
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
    //POST
    public PlayerDTO createPlayer(PlayerDTO playerDTO){
        Player createdPlayer = new Player();
        createdPlayer.setFirstName(playerDTO.getFirstName());
        createdPlayer.setLastName(playerDTO.getLastName());
        createdPlayer.setAge(playerDTO.getAge());
        createdPlayer.setPosition(playerDTO.getPosition());
        if(playerDTO.getTeamId() != null) {
            Team team = teamRepository.findById(playerDTO.getTeamId())
                    .orElseThrow(() -> new RuntimeException("team not found with id: " + playerDTO.getTeamId()));
            createdPlayer.setTeam(team);
        }
        else {
            createdPlayer.setTeam(null);
        }

        playerRepository.save(createdPlayer);

        PlayerDTO dto = new PlayerDTO();
        dto.setId(createdPlayer.getId());
        dto.setFirstName(createdPlayer.getFirstName());
        dto.setLastName(createdPlayer.getLastName());
        dto.setAge(createdPlayer.getAge());
        dto.setPosition(createdPlayer.getPosition());
        if(createdPlayer.getTeam() != null) {
            dto.setTeamId(createdPlayer.getTeam().getId());
            dto.setTeamName(createdPlayer.getTeam().getName());
        }

        return dto;
    }

    //PUT
    public PlayerDTO updatePlayer(Integer id, PlayerDTO playerDTO) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + id));

        player.setFirstName(playerDTO.getFirstName());
        player.setLastName(playerDTO.getLastName());
        player.setAge(playerDTO.getAge());
        player.setPosition(playerDTO.getPosition());
        if(playerDTO.getTeamId() != null) {
            Team team = teamRepository.findById(playerDTO.getTeamId())
                    .orElseThrow(() -> new RuntimeException("Team not found with id: " + playerDTO.getTeamId()));
            player.setTeam(team);
        }
        else {
            player.setTeam(null);
        }

        playerRepository.save(player);

        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setFirstName(player.getFirstName());
        dto.setLastName(player.getLastName());
        dto.setAge(player.getAge());
        dto.setPosition(player.getPosition());
        if(player.getTeam() != null) {
            dto.setTeamId(player.getTeam().getId());
            dto.setTeamName(player.getTeam().getName());
        }

        return dto;
    }

    //DELETE
    public void deletePlayer(Integer id) {
        if(!playerRepository.existsById(id)) {
            throw new RuntimeException("Player not found with id: " + id);
        }
        playerRepository.deleteById(id);
    }
}
