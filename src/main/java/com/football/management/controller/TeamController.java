package com.football.management.controller;

import com.football.management.dto.TeamDTO;
import com.football.management.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamDTO> getAllTeams(){
        return teamService.getAllTeams();
    }
}
