package com.football.management.controller;

import com.football.management.dto.PlayerDTO;
import com.football.management.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List <PlayerDTO> getAllPlayers(){
        return playerService.getAllPlayers();
    }
}
