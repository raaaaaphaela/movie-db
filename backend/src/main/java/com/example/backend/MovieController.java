package com.example.backend;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies () {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById (@PathVariable String id) {
        return movieService.getMovieById(Integer.parseInt(id));
    }
}
