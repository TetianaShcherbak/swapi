package com.swapi.demo.dao;

import com.swapi.demo.entity.FilmEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SwapiFilmDao {

    private final SwapiHttpClient httpClient;

    public SwapiFilmDao(SwapiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public FilmEntity findById(int id) {
        return httpClient.get("/films/" + id, FilmEntity.class);
    }

    public List<FilmEntity> findAll() {
        return Arrays.asList(
                httpClient.get("/films", FilmEntity[].class)
        );
    }

    public FilmEntity fetchByUrl(String absoluteUrl) {
        return httpClient.getByUrl(absoluteUrl, FilmEntity.class);
    }
}