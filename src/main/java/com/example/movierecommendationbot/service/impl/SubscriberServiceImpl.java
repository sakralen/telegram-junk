package com.example.movierecommendationbot.service.impl;

import com.example.movierecommendationbot.repository.SubscriberRepository;
import com.example.movierecommendationbot.service.SubscriberService;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceImpl implements SubscriberService {
    private final SubscriberRepository subscriberRepository;

    public SubscriberServiceImpl(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }
}
