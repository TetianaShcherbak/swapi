package com.swapi.demo.mapper;

import com.swapi.demo.dto.FilmSimpleDTO;
import com.swapi.demo.dto.PersonSimpleDTO;
import com.swapi.demo.dto.response.PersonResponseDTO;
import com.swapi.demo.entity.PersonEntity;

import java.util.ArrayList;
import java.util.List;

public class PersonMapper implements StringToDateInterface{
    private final PersonEntity personEntity;

    public PersonMapper(PersonEntity personEntity){
        this.personEntity = personEntity;
    }

    public PersonResponseDTO getFullResponseDTO(){

        return new PersonResponseDTO(
                personEntity.name(),
                personEntity.height(),
                personEntity.mass(),
                personEntity.hairColor(),
                personEntity.skinColor(),
                personEntity.eyeColor(),
                personEntity.birthYear(),
                personEntity.gender(),
                personEntity.homeworld(),
                convertDateFormat(personEntity.created()),
                convertDateFormat(personEntity.edited()),
                personEntity.url(),
                getFilms(personEntity.films()),
                personEntity.species(),
                personEntity.vehicles(),
                personEntity.starships()
        );
    }

    public PersonSimpleDTO getSimpleDTO(){
        String url = personEntity.url();
        int id = Integer.parseInt(url.substring(url.lastIndexOf('-') + 1));
        return new PersonSimpleDTO(id, url);
    }


    private List<FilmSimpleDTO> getFilms(List<String> films){
        if (films.isEmpty()) return new ArrayList<>();
        List<FilmSimpleDTO> movies = new ArrayList<>();

        for (String f: films){
            int id = Integer.parseInt(f.substring(f.lastIndexOf('/') + 1));
            movies.add(new FilmSimpleDTO(id, f));
        }

        return movies;
    }
}
