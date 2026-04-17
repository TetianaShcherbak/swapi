package com.swapi.demo.controller;

import com.swapi.demo.dto.request.FilmFilterDTO;
import com.swapi.demo.dto.response.FilmResponseDTO;
import com.swapi.demo.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    // GET /films
    // GET /films?director=Lucas&year=1977
    @GetMapping
    public ResponseEntity<List<FilmResponseDTO>> getFilms(@RequestBody FilmFilterDTO filter) {
        return ResponseEntity.ok(filmService.filter(filter));
    }

    // GET /films/1
    @GetMapping("/{id}")
    public ResponseEntity<FilmResponseDTO> getFilmById(@PathVariable int id) {
        return ResponseEntity.ok(filmService.findById(id));
    }

    // GET /films/by-actor/1  → all films Luke Skywalker appeared in
    @GetMapping("/by-actor/{personId}")
    public ResponseEntity<List<FilmResponseDTO>> getFilmsByActor(@PathVariable int personId) {
        return ResponseEntity.ok(filmService.findByActor(personId));
    }
}