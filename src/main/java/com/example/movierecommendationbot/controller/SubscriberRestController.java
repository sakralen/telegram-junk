package com.example.movierecommendationbot.controller;

import com.example.movierecommendationbot.model.Movie;
import com.example.movierecommendationbot.model.Subscriber;
import com.example.movierecommendationbot.service.SubscriberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SubscriberRestController {
    private final SubscriberService subscriberService;

    public SubscriberRestController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @GetMapping("/nickname/{nickname}")
    public Subscriber getByName(@PathVariable String nickname) {
        return Subscriber.builder()
                .name("Tyler Durden")
                .id(1337L)
                .movies(List.of(Movie.builder().name("Fight Club").build()))
                .build();
    }
}
