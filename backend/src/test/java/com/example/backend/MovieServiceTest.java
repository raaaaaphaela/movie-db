package com.example.backend;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieServiceTest {

    MovieRepository repository = mock(MovieRepository.class);
    MovieService service = new MovieService(repository);


    // methodeName_whenXYZ_shouldXYZ

    @Test
    public void getAllMovies_whenListEmpty_returnEmptyList() {
        // given
        List<Movie> expected = new ArrayList<>();
        when(repository.getAllMovies()).thenReturn(expected);

        // when
        List<Movie> actual = service.getAllMovies();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void getAllMovies_whenListHasOneMovie_returnOneMovie() {
        // given
        Movie movie = new Movie(1, "Lion King", "https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg", 1994);
        List<Movie> expected = new ArrayList<>();
        expected.add(movie);

        when(repository.getAllMovies()).thenReturn(expected);

        // when
        List<Movie> actual = service.getAllMovies();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void getMovieById_whenMovieIdExists_returnMovie() {
        // given
        Movie movie = new Movie(1, "Lion King", "https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg", 1994);

        when(repository.getMovieById(1)).thenReturn(movie);

        // when
        Movie actual = service.getMovieById(1);

        // then
        assertEquals(movie, actual);
    }

    @Test
    public void getMovieById_whenMovieDoesNotExists_returnNull() {
        // given

        when(repository.getMovieById(2)).thenReturn(null);

        // when
        Movie actual = service.getMovieById(2);

        // then
        assertNull(actual);
    }

}