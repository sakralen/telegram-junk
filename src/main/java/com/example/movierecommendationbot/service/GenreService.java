package com.example.movierecommendationbot.service;

import com.example.movierecommendationbot.model.Genre;
import com.example.movierecommendationbot.model.Movie;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Optional<Genre> findById(Long id);

    List<Genre> findAll();

    Optional<Genre> findByName(String name);

    List<Movie> findMoviesByGenreName(String name);

    public String recommendRandomMovieByGenreName(String name);
}
