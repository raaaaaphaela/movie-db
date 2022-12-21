package com.example.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
@AllArgsConstructor
public class MovieRepository {

    private List<Movie> movies;

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(int id) {
        return movies.stream().filter(movie -> id == movie.getId()).findFirst().orElse(null);
    }

    public Movie addMovie(Movie newMovie) {
        int newID = movies.size() + 1;
        if (newMovie != null) {
            newMovie.setId(newID);
            movies.add(newMovie);
            return getMovieById(newID);
        } else {
            return null;
        }
    }

    public void deleteMovie(int id) {
        movies.removeIf(movie -> movie.getId() == id);
    }

    public Movie makeFavorite(Movie favMovie) {

        return movies.stream().filter(movie -> {
            if (movie.getId() == favMovie.getId()) {
                movie.setFavorite(favMovie.isFavorite());
                return true;
            }
            return false;
        }).findFirst().orElse(null);
    }

    public List<Movie> getFavoriteMovies() {
        return movies.stream().filter(Movie::isFavorite).collect(Collectors.toList());
    }
}
