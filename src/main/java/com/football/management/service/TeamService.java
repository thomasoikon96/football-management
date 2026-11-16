package com.football.management.service;

import com.football.management.dto.CountryDTO;
import com.football.management.dto.TeamDTO;
import com.football.management.entity.Country;
import com.football.management.entity.Team;
import com.football.management.repository.CountryRepository;
import com.football.management.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private CountryRepository countryRepository;

    //GET
    public List <TeamDTO> getAllTeams() {

        List <Team> teams = teamRepository.findAll();
        List <TeamDTO> teamDTOs = new ArrayList<>();

        for (Team team : teams) {
            TeamDTO dto = new TeamDTO();

            dto.setId(team.getId());
            dto.setName(team.getName());
            dto.setYearFounded(team.getYearFounded());

            if(team.getCountry() != null) {
                CountryDTO countryDTO = new CountryDTO();
                countryDTO.setId(team.getCountry().getId());
                countryDTO.setName(team.getCountry().getName());
                dto.setCountry(countryDTO);
            }

            teamDTOs.add(dto);
        }

        return teamDTOs;
    }

    //POST
    public TeamDTO createTeam(TeamDTO teamDTO) {
        Team createdTeam = new Team();
        createdTeam.setName(teamDTO.getName());
        createdTeam.setYearFounded(teamDTO.getYearFounded());

        if(teamDTO.getCountry() != null && teamDTO.getCountry().getId() != null) {
            Country country = countryRepository.findById(teamDTO.getCountry().getId())
                    .orElseThrow(() -> new RuntimeException("Country not found with id: " + teamDTO.getCountry().getId()));
            createdTeam.setCountry(country);
        }

        teamRepository.save(createdTeam);

        TeamDTO dto = new TeamDTO();
        dto.setId(createdTeam.getId());
        dto.setName(createdTeam.getName());
        dto.setYearFounded(createdTeam.getYearFounded());

        if(createdTeam.getCountry() != null) {
            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setId(createdTeam.getCountry().getId());
            countryDTO.setName(createdTeam.getCountry().getName());
            dto.setCountry(countryDTO);
        }

        return dto;
    }

    //PUT
    public TeamDTO updateTeam(Integer id, TeamDTO teamDTO) {
        Team updatedTeam = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + id));

        updatedTeam.setName(teamDTO.getName());
        updatedTeam.setYearFounded(teamDTO.getYearFounded());

        if(teamDTO.getCountry() != null && teamDTO.getCountry().getId() != null) {
            Country country = countryRepository.findById(teamDTO.getCountry().getId())
                    .orElseThrow(() -> new RuntimeException("Country not found with id: " + teamDTO.getCountry().getId()));
            updatedTeam.setCountry(country);
        }

        teamRepository.save(updatedTeam);

        TeamDTO dto = new TeamDTO();
        dto.setId(updatedTeam.getId());
        dto.setName(updatedTeam.getName());
        dto.setYearFounded(updatedTeam.getYearFounded());

        if(updatedTeam.getCountry() != null) {
            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setId(updatedTeam.getCountry().getId());
            countryDTO.setName(updatedTeam.getCountry().getName());
        }

        return dto;
    }

    //DELETE
    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }

}
