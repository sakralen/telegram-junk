package com.example.movierecommendationbot.service.impl;

import com.example.movierecommendationbot.model.Movie;
import com.example.movierecommendationbot.repository.MovieRepository;
import com.example.movierecommendationbot.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findByName(String name) {
        return movieRepository.findAll().stream()
                .filter(m -> m.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Movie> findByGenreId(Long genreId) {
        return movieRepository.findAll().stream()
                .filter(m -> m.getGenre().getId().equals(genreId))
                .toList();
    }
}
