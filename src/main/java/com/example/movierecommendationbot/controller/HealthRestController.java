package com.example.movierecommendationbot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthRestController {
    @GetMapping("/health")
    public String checkHealth() {
        return "All good!\n";
    }
}
