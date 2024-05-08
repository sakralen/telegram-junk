package com.example.movierecommendationbot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "name")
@Builder
@NamedEntityGraph(name = "SubscriberWithGenres", attributeNodes = @NamedAttributeNode("genres"))
@NamedEntityGraph(name = "SubscriberWithMovies", attributeNodes = @NamedAttributeNode("movies"))
@NamedEntityGraph(name = "SubscriberWithMoviesAndGenres",
        attributeNodes = {@NamedAttributeNode("movies"), @NamedAttributeNode("genres")})
@Entity
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "subscriber_genre",
            joinColumns = @JoinColumn(name = "subscriber_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres = new ArrayList<>();


    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "subscriber_movie",
            joinColumns = @JoinColumn(name = "subscriber_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies = new ArrayList<>();

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
