package com.example.movierecommendationbot.service;

import com.example.movierecommendationbot.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Optional<Movie> findById(Long id);

    List<Movie> findAll();

    Optional<Movie> findByName(String name);

    List<Movie> findByGenreId(Long genreId);
}
