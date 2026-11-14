package com.football.management.controller;

import com.football.management.dto.CountryDTO;
import com.football.management.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List <CountryDTO> getAllCountries () {
        return countryService.getAllCountries();
    }

    @PostMapping
    public CountryDTO createCountry(@RequestBody CountryDTO countryDTO) {
        return countryService.createCountry(countryDTO);
    }
}
