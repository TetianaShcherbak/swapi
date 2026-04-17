package com.swapi.demo.dao;

import com.swapi.demo.entity.PersonEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SwapiPersonDao {

    private final SwapiHttpClient httpClient;

    public SwapiPersonDao(SwapiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public PersonEntity findById(int id) {
        return httpClient.get("/people/" + id, PersonEntity.class);
    }

    public List<PersonEntity> findAll() {
        return Arrays.asList(
                httpClient.get("/people", PersonEntity[].class)
        );
    }
}
