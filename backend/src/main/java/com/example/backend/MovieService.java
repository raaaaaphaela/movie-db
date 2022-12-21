package com.example.backend;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public Movie getMovieById(int id) {
        return movieRepository.getMovieById(id);
    }

    public Movie addMovie(Movie newMovie) {
        return movieRepository.addMovie(newMovie);
    }

    public void deleteMovie(int id) {
        movieRepository.deleteMovie(id);

    }

    public Movie makeFavorite(Movie favMovie) {
        return movieRepository.makeFavorite(favMovie);
    }
}
