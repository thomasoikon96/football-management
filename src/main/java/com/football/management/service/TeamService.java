package com.football.management.service;

import com.football.management.dto.CountryDTO;
import com.football.management.dto.TeamDTO;
import com.football.management.entity.Country;
import com.football.management.entity.Team;
import com.football.management.repository.CountryRepository;
import com.football.management.repository.TeamRepository;
import org.springframework.beans.BeanUtils;
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
            BeanUtils.copyProperties(team, dto, "country");

            if(team.getCountry() != null) {
                CountryDTO countryDTO = new CountryDTO();
                BeanUtils.copyProperties(team.getCountry(), countryDTO);
                dto.setCountry(countryDTO);
            }

            teamDTOs.add(dto);
        }

        return teamDTOs;
    }

    //POST
    public TeamDTO createTeam(TeamDTO teamDTO) {
        Team createdTeam = new Team();
        BeanUtils.copyProperties(teamDTO, createdTeam, "id", "country");

        if(teamDTO.getCountry() != null && teamDTO.getCountry().getId() != null) {
            Country country = countryRepository.findById(teamDTO.getCountry().getId())
                    .orElseThrow(() -> new RuntimeException("Country not found with id: " + teamDTO.getCountry().getId()));
            createdTeam.setCountry(country);
        }

        teamRepository.save(createdTeam);

        TeamDTO dto = new TeamDTO();
        BeanUtils.copyProperties(createdTeam, dto, "country");

        if(createdTeam.getCountry() != null) {
            CountryDTO countryDTO = new CountryDTO();
            BeanUtils.copyProperties(createdTeam.getCountry(), countryDTO);
            dto.setCountry(countryDTO);
        }

        return dto;
    }

    //PUT
    public TeamDTO updateTeam(Integer id, TeamDTO teamDTO) {
        Team updatedTeam = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + id));

        BeanUtils.copyProperties(teamDTO,updatedTeam, "id", "country");

        if(teamDTO.getCountry() != null && teamDTO.getCountry().getId() != null) {
            Country country = countryRepository.findById(teamDTO.getCountry().getId())
                    .orElseThrow(() -> new RuntimeException("Country not found with id: " + teamDTO.getCountry().getId()));
            updatedTeam.setCountry(country);
        }

        teamRepository.save(updatedTeam);

        TeamDTO dto = new TeamDTO();
        BeanUtils.copyProperties(updatedTeam, dto, "country");

        if(updatedTeam.getCountry() != null) {
            CountryDTO countryDTO = new CountryDTO();
            BeanUtils.copyProperties(updatedTeam.getCountry(), countryDTO);
            dto.setCountry(countryDTO);
        }

        return dto;
    }

    //DELETE
    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }

}
