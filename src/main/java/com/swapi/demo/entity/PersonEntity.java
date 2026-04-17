package com.swapi.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public record PersonEntity (
        String name,
        int height,
        int mass,
        @JsonProperty("hair_color")  String hairColor,
        @JsonProperty("skin_color")  String skinColor,
        @JsonProperty("eye_color")  String eyeColor,
        @JsonProperty("birth_year")  String birthYear,
        String gender,
        String homeworld,
        String created,
        String edited,
        String url,

        List<String> films,
        List<String> species,
        List<String> vehicles,
        List<String> starships
){}
