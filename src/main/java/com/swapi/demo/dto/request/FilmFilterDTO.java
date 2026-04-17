package com.swapi.demo.dto.request;

public record FilmFilterDTO(
        String director,
        String title,
        Integer episodeId,
        Integer year
) {}
