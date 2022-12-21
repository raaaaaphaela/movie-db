package com.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    void addNewMovie_returnAllMovies() throws Exception {

        //given
        String postJSON = """
                    {
                            "title": "Herr der Ringe",
                            "imageUrl": "https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg",
                            "year": 2001,
                            "favorite": false
                        }
                """;

        String newJSON = """
                    {
                            "id": 1,
                            "title": "Herr der Ringe",
                            "imageUrl": "https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg",
                            "year": 2001,
                            "favorite": false
                        }
                """;

        String expectedJSON = """
                    [
                      {
                            "id": 1,
                            "title": "Herr der Ringe",
                            "imageUrl": "https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg",
                            "year": 2001,
                            "favorite": false
                        }
                   ]     
                """;

        mvc.perform(MockMvcRequestBuilders.post("/api/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postJSON))
                .andExpect(status().isOk())
                .andExpect(content().json(newJSON));

        mvc.perform(MockMvcRequestBuilders.get("/api/movies"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    void changeMovieToFavorite_ReturnUpdatedMovie() throws Exception {
        //given
        String postJSON = """
                    {
                            "title": "Lion King",
                            "imageUrl": "https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg",
                            "year": 1994,
                            "favorite": false
                        }
                """;

        String expectedJSON = """
                    
                        {
                            "id": 1,
                            "title": "Lion King",
                            "imageUrl": "https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg",
                            "year": 1994,
                            "favorite": false
                        }
                    
                """;

        String putJSON = """
                    {
                            "id": 1,
                            "title": "Lion King",
                            "imageUrl": "https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg",
                            "year": 1994,
                            "favorite": true
                        }
                """;

        String expectedFavoriteJSON = """
                    
                        {
                            "id": 1,
                            "title": "Lion King",
                            "imageUrl": "https://m.media-amazon.com/images/I/81ETY9fq1YL._SY445_.jpg",
                            "year": 1994,
                            "favorite": true
                        }
                    
                """;

        mvc.perform(MockMvcRequestBuilders.post("/api/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postJSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));

        mvc.perform(MockMvcRequestBuilders.get("/api/movies/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));

        mvc.perform(MockMvcRequestBuilders.put("/api/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(putJSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedFavoriteJSON));

        mvc.perform(MockMvcRequestBuilders.get("/api/movies/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedFavoriteJSON));
    }

}