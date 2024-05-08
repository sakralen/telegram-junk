package com.example.movierecommendationbot.repository;

import com.example.movierecommendationbot.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
