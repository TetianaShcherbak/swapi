package com.swapi.demo.service;

import com.swapi.demo.dao.SwapiFilmDao;
import com.swapi.demo.dao.SwapiPersonDao;
import com.swapi.demo.dto.request.FilmFilterDTO;
import com.swapi.demo.dto.response.FilmResponseDTO;
import com.swapi.demo.entity.FilmEntity;
import com.swapi.demo.entity.PersonEntity;
import com.swapi.demo.mapper.FilmMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {
    private SwapiPersonDao personDao;
    private SwapiFilmDao filmDao;

    public FilmService(SwapiPersonDao personDao, SwapiFilmDao filmDao) {
        this.personDao = personDao;
        this.filmDao = filmDao;
    }

    public List<FilmResponseDTO> filter(FilmFilterDTO filter) {
        FilmEntity filmEntity = filmDao.findById(filter.episodeId());
        // todo: some logic for filtering movies... but in our case every such request will return distinct record
        return filmEntity == null ? null : new ArrayList<>(Collections.singleton(new FilmMapper(filmEntity).getFullResponseDTO()));
    }


    public FilmResponseDTO findById(int id) {
        FilmEntity filmEntity = filmDao.findById(id);
        return new FilmMapper(filmEntity).getFullResponseDTO();
    }


    public List<FilmResponseDTO> findByActor(int personId) {

        PersonEntity person = personDao.findById(personId);  // → GET /people/1

        return person.films().stream()
                .map(filmUrl -> filmDao.fetchByUrl(filmUrl)) // → GET each absolute film URL
                .map(FilmMapper::new)
                .map(FilmMapper::getFullResponseDTO)
                .collect(Collectors.toList());
    }
}
