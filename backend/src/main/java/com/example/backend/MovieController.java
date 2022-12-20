package com.example.backend;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Movie addMovie (@RequestBody Movie newMovie) {
        return movieService.addMovie(newMovie);
    }

    @DeleteMapping("/{id}")
    public void addMovie (@PathVariable String id) {
         movieService.deleteMovie(Integer.parseInt(id));
    }
}
