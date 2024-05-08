package com.example.movierecommendationbot.repository;

import com.example.movierecommendationbot.model.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Override
    @EntityGraph("MovieWithGenre")
    List<Movie> findAll();

    @Override
    @EntityGraph("MovieWithGenre")
    Optional<Movie> findById(Long aLong);
}
