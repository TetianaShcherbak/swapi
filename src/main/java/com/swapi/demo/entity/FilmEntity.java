package com.swapi.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record FilmEntity(
        String title,
        @JsonProperty("episode_id")   int episodeId,
        String director,
        String producer,
        int year,
        @JsonProperty("release_date") String releaseDate,
        String created,
        String edited,
        String url,
        @JsonProperty("opening_crawl") String openingCrawl,
        List<String> characters,
        List<String> planets,
        List<String> starships,
        List<String> vehicles,
        List<String> species
) {}