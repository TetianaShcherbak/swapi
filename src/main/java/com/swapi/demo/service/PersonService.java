package com.swapi.demo.service;

import com.swapi.demo.dao.SwapiPersonDao;
import com.swapi.demo.dto.response.PersonResponseDTO;
import com.swapi.demo.entity.PersonEntity;
import com.swapi.demo.mapper.PersonMapper;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final SwapiPersonDao personDao;

    public PersonService(SwapiPersonDao personDao) {
        this.personDao = personDao;
    }

    public PersonResponseDTO findById(int id) {
        PersonEntity personEntity = personDao.findById(id);
        return new PersonMapper(personEntity).getFullResponseDTO();
    }
}
