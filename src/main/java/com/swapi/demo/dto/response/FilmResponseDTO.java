package com.swapi.demo.dto.response;


import com.swapi.demo.dto.PersonSimpleDTO;

import java.util.Date;
import java.util.List;

public record FilmResponseDTO(
        String director,
        String title,
        Integer episodeId,
        Integer year,
        String openingCrawl,
        String producer,
        Date releaseDate,
        Date created,
        Date edited,
        String url,

        List<PersonSimpleDTO> characters,
        List<String> planets,
        List<String> starships,
        List<String> vehicles,
        List<String> species
) {}