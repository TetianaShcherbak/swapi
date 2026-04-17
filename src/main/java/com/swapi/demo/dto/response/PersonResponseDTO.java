package com.swapi.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swapi.demo.dto.FilmSimpleDTO;

import java.util.Date;
import java.util.List;

public record PersonResponseDTO (
    String name,
    int height,
    int mass,
    @JsonProperty("hair_color")  String hairColor,
    @JsonProperty("skin_color")  String skinColor,
    @JsonProperty("eye_color")  String eyeColor,
    @JsonProperty("birth_year")  String birthYear,
    String gender,
    String homeworld,
    Date created,
    Date edited,
    String url,

    List<FilmSimpleDTO> films,
    List<String> species,
    List<String> vehicles,
    List<String> starships
){}
