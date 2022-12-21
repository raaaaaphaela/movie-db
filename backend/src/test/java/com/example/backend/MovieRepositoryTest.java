package com.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class MovieRepositoryTest {

    @Test
    public void getAllMovies_whenListEmpty_returnEmptyList () {
        // given
        List<Movie> expected = new ArrayList<>();
        MovieRepository repository = new MovieRepository(expected);

        // when
       List<Movie> actual = repository.getAllMovies();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void getAllMovies_whenListHasOneMovie_returnOneMovie () {
        // given
        Movie movie = new Movie();
        List<Movie> expected = new ArrayList<>();
        expected.add(movie);

        MovieRepository repository = new MovieRepository(expected);

        // when
        List<Movie> actual = repository.getAllMovies();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void getMovieById_whenMovieIdExists_returnMovie () {
        // given
        Movie movie = new Movie(1, "Lion King", "https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg", 1994, false);
        List<Movie> expected = new ArrayList<>();
        expected.add(movie);

        MovieRepository repository = new MovieRepository(expected);

        // when
        Movie actual = repository.getMovieById(1);

        // then
        assertEquals(movie, actual);
    }

    @Test
    public void getMovieById_whenMovieDoesNotExists_returnNull () {
        // given
        Movie movie = new Movie(1, "Lion King", "https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg", 1994, false);
        List<Movie> expected = new ArrayList<>();
        expected.add(movie);

        MovieRepository repository = new MovieRepository(expected);

        // when
        Movie actual = repository.getMovieById(2);

        // then
        assertNull(actual);
    }

    @Test
    public void addMovie_whenSuccessful_returnNewMovie () {
        // given
        Movie movie = new Movie();
        movie.setTitle("Lion King");
        movie.setImageUrl("https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg");
        movie.setYear(1994);

        MovieRepository repository = new MovieRepository(new ArrayList<>());

        // when
        Movie actual = repository.addMovie(movie);
        movie.setId(1);

        // then
        assertEquals(movie, actual);
    }

    @Test
    public void deleteMovie_whenSuccessful_listShouldBeWithoutIt () {
        // given
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Lion King");
        movie.setImageUrl("https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg");
        movie.setYear(1994);

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        MovieRepository repository = new MovieRepository(movies);

        // when
        repository.deleteMovie(1);

        // then
        assertEquals(new ArrayList<>(), movies);
    }

}