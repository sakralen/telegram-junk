package com.example.movierecommendationbot.controller;

import com.example.movierecommendationbot.model.Movie;
import com.example.movierecommendationbot.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/movie")
public class MovieRestController {
    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/id/{id}")
    public Movie findById(@PathVariable Long id) {
        return movieService.findById(id).orElseGet(Movie::new);
    }

    @GetMapping("/name/{name}")
    public Movie findByName(@PathVariable String name) {
        return movieService.findByName(name.toLowerCase(Locale.ROOT)).orElseGet(Movie::new);
    }

    @GetMapping("")
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/genre/{genreId}")
    public List<Movie> findByGenreId(@PathVariable Long genreId) {
        return movieService.findByGenreId(genreId);
    }
}
