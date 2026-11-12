package com.football.management.service;

import com.football.management.dto.TeamDTO;
import com.football.management.entity.Team;
import com.football.management.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    //GET
    public List <TeamDTO> getAllTeams() {

        List <Team> teams = teamRepository.findAll();
        List <TeamDTO> teamDTOs = new ArrayList<>();

        for (Team team : teams) {
            TeamDTO dto = new TeamDTO();

            dto.setId(team.getId());
            dto.setName(team.getName());
            dto.setCountry(team.getCountry());
            dto.setYearFounded(team.getYearFounded());

            teamDTOs.add(dto);
        }

        return teamDTOs;
    }

    //POST
    public TeamDTO createTeam(TeamDTO teamDTO) {
        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setCountry(teamDTO.getCountry());
        team.setYearFounded(teamDTO.getYearFounded());

        Team savedTeam = teamRepository.save(team);

        TeamDTO dto = new TeamDTO();
        dto.setId(savedTeam.getId());
        dto.setName(savedTeam.getName());
        dto.setCountry(savedTeam.getCountry());
        dto.setYearFounded(savedTeam.getYearFounded());

        return dto;
    }

    //PUT
    public TeamDTO updateTeam(Integer id, TeamDTO teamDTO) {
        Team updatedTeam = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + id));

        updatedTeam.setName(teamDTO.getName());
        updatedTeam.setCountry(teamDTO.getCountry());
        updatedTeam.setYearFounded(teamDTO.getYearFounded());

        teamRepository.save(updatedTeam);

        TeamDTO dto = new TeamDTO();
        dto.setId(updatedTeam.getId());
        dto.setName(updatedTeam.getName());
        dto.setCountry(updatedTeam.getCountry());
        dto.setYearFounded(updatedTeam.getYearFounded());

        return dto;
    }

    //DELETE
    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }

}
