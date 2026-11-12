package com.football.management.controller;

import com.football.management.dto.TeamDTO;
import com.football.management.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<TeamDTO> getAllTeams(){
        return teamService.getAllTeams();
    }

    @PostMapping
    public TeamDTO createTeam(@RequestBody TeamDTO teamDTO) {
        return teamService.createTeam(teamDTO);
    }

    @PutMapping("/{id}")
    public TeamDTO updateTeam(@PathVariable Integer id, @RequestBody TeamDTO teamDTO) {
        return teamService.updateTeam(id, teamDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Integer id) {
        teamService.deleteTeam(id);
    }
}
