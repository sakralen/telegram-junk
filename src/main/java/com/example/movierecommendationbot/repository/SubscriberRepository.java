package com.example.movierecommendationbot.repository;

import com.example.movierecommendationbot.model.Subscriber;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
    @Override
    @EntityGraph("SubscriberWithMoviesAndGenres")
    Optional<Subscriber> findById(Long aLong);

    @Override
    @EntityGraph("SubscriberWithMoviesAndGenres")
    List<Subscriber> findAll();
}
