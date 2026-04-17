package com.swapi.demo.mapper;

import com.swapi.demo.dto.FilmSimpleDTO;
import com.swapi.demo.dto.PersonSimpleDTO;
import com.swapi.demo.dto.response.FilmResponseDTO;
import com.swapi.demo.entity.FilmEntity;

import java.util.*;

public class FilmMapper implements StringToDateInterface{
    private final FilmEntity filmEntity;

    public FilmMapper(FilmEntity filmEntity){
        this.filmEntity = filmEntity;
    }

    public FilmResponseDTO getFullResponseDTO(){

        return new FilmResponseDTO(
                filmEntity.director(),
                filmEntity.title(),
                filmEntity.episodeId(),
                filmEntity.year(),
                filmEntity.openingCrawl(),
                filmEntity.producer(),
                convertDateFormat(filmEntity.releaseDate()),
                convertDateFormat(filmEntity.created()),
                convertDateFormat(filmEntity.edited()),
                filmEntity.url(),
                getCharacters(filmEntity.characters()),
                filmEntity.planets(),
                filmEntity.starships(),
                filmEntity.vehicles(),
                filmEntity.species()
        );
    }

    public FilmSimpleDTO getSimpleDTO(){
        return new FilmSimpleDTO(filmEntity.episodeId(), filmEntity.url());
    }

    private List<PersonSimpleDTO> getCharacters(List<String> characters){
        if (characters.isEmpty()) return new ArrayList<>();
        List<PersonSimpleDTO> persons = new ArrayList<>();

        for (String ch: characters){
            int id = Integer.parseInt(ch.substring(ch.lastIndexOf('/') + 1));
            persons.add(new PersonSimpleDTO(id, ch));
        }

        return persons;
    }
}
