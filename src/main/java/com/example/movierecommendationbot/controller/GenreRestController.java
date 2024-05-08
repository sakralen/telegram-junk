package com.example.movierecommendationbot.controller;

import com.example.movierecommendationbot.model.Genre;
import com.example.movierecommendationbot.model.Movie;
import com.example.movierecommendationbot.service.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/genre")
public class GenreRestController {
    private final GenreService genreService;

    public GenreRestController(GenreService genreService) {
        super();
        this.genreService = genreService;
    }

    @GetMapping("")
    public List<Genre> findAll() {
        return genreService.findAll();
    }

    @GetMapping("/id/{id}")
    public Genre findById(@PathVariable Long id) {
        return genreService.findById(id).orElseGet(Genre::new);
    }

    @GetMapping("/name/{name}")
    public Genre findByName(@PathVariable String name) {
        return genreService.findByName(name.toLowerCase(Locale.ROOT)).orElseGet(Genre::new);
    }

    @GetMapping("/name/{name}/movie")
    public List<Movie> getMoviesByGenreName(@PathVariable String name) {
        return genreService.findMoviesByGenreName(name);
    }

    @GetMapping("/name/{name}/recommend")
    public String recommendByGenreName(@PathVariable String name) {
        return genreService.recommendRandomMovieByGenreName(name);
    }
}
