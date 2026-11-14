package com.football.management.service;

import com.football.management.dto.CountryDTO;
import com.football.management.entity.Country;
import com.football.management.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<CountryDTO> getAllCountries(){
        List <Country> countries = countryRepository.findAll();
        List <CountryDTO> countryDTOs = new ArrayList<>();

        for(Country country: countries) {
            CountryDTO dto = new CountryDTO();
            dto.setId(country.getId());
            dto.setName(country.getName());
            countryDTOs.add(dto);
        }

        return countryDTOs;
    }

    public CountryDTO createCountry(CountryDTO countryDTO) {
        Country country = new Country();
        country.setName(countryDTO.getName());

        countryRepository.save(country);

        CountryDTO responseDTO = new CountryDTO();
        responseDTO.setId(country.getId());
        responseDTO.setName(country.getName());

        return responseDTO;
    }
}
