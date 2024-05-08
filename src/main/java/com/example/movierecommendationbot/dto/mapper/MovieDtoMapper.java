package com.example.movierecommendationbot.dto.mapper;

import com.example.movierecommendationbot.dto.MovieDto;
import com.example.movierecommendationbot.model.Movie;

public class MovieDtoMapper implements DtoMapper<Movie, MovieDto> {
    @Override
    public MovieDto toDto(Movie entity) {
        return new MovieDto(entity.getName(), entity.getGenre().getName());
    }
}
