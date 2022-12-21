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

    @GetMapping("/favorites")
    public List<Movie> getFavoriteMovies() {
        return movieService.getFavoriteMovies();
    }

    @PostMapping
    public Movie addMovie (@RequestBody Movie newMovie) {
        return movieService.addMovie(newMovie);
    }

    @DeleteMapping("/{id}")
    public void addMovie (@PathVariable String id) {
         movieService.deleteMovie(Integer.parseInt(id));
    }

    @PutMapping()
    public Movie makeFavorite (@RequestBody Movie favMovie) {
        return movieService.makeFavorite(favMovie);
    }
}
