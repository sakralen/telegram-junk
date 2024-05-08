package com.example.movierecommendationbot.service.impl;

import com.example.movierecommendationbot.dto.mapper.MovieDtoMapper;
import com.example.movierecommendationbot.model.Genre;
import com.example.movierecommendationbot.model.Movie;
import com.example.movierecommendationbot.repository.GenreRepository;
import com.example.movierecommendationbot.repository.MovieRepository;
import com.example.movierecommendationbot.service.GenreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MovieRepository movieRepository;

    private static MovieDtoMapper mapper = new MovieDtoMapper();

    @Override
    public Optional<Genre> findById(Long id) {
        return genreRepository.findById(id);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> findByName(String name) {
        return findAll().stream().filter(g -> g.getName().toLowerCase().equals(name)).findFirst();
    }

    @Override
    public List<Movie> findMoviesByGenreName(String name) {
        return movieRepository.findAll().stream()
                .filter(m -> m.getGenre().getName().toLowerCase(Locale.ROOT).equals(name))
                .toList();
    }

    @Override
    public String recommendRandomMovieByGenreName(String name) {
        List<Movie> movies = findMoviesByGenreName(name);
        Movie movie = movies.get(new Random().nextInt(movies.size()));

        return movie.getName();
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            return objectMapper.writeValueAsString(mapper.toDto(movie));
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
    }
}
