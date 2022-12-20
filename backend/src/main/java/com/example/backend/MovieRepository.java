package com.example.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@AllArgsConstructor
public class MovieRepository {

    private List<Movie> movies = new ArrayList<>();

    public MovieRepository() {
        Movie lionKing = new Movie(1, "Lion King", "https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg", 1994);
        Movie harryPotter = new Movie(2, "Harry Potter", "https://assets.cdn.moviepilot.de/files/442156878a6b9830e5b55d717f307eeed0b29f1d68a85527d107ca548c98/limit/500/1000/harry-potter-und-der-stein-der-weisen-poster.jpg", 2001);

        movies.add(lionKing);
        movies.add(harryPotter);
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(int id) {
        return movies.stream().filter(movie -> id == movie.getId()).findFirst().orElse(null);
    }
}
