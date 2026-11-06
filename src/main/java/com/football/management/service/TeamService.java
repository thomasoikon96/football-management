package com.football.management.service;

import com.football.management.dto.TeamDTO;
import com.football.management.entity.Team;
import com.football.management.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public List <TeamDTO> getAllTeams(){

        List<Team> teams = teamRepository.findAll();
        List<TeamDTO> teamDTOs = new ArrayList<>();

        for(Team team : teams){
            TeamDTO dto = new TeamDTO();

            dto.setId(team.getId());
            dto.setName(team.getName());
            dto.setCountry(team.getCountry());
            dto.setYearFounded(team.getYearFounded());

            teamDTOs.add(dto);
        }

        return teamDTOs;
    }


}
