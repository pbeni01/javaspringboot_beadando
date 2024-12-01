package com.example.mozimusorbeadando.controller;

import com.example.mozimusorbeadando.model.Film;
import com.example.mozimusorbeadando.repository.FilmRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @PostMapping
    public Film createFilm(@RequestBody Film film) {
        return filmRepository.save(film);
    }
}