package com.example.movierecommendationbot.dto.mapper;

public interface DtoMapper<E, D> {
    D toDto(E entity);
}
