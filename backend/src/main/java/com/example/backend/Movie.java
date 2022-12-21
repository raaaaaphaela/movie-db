package com.example.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private int id;
    private String title;
    private String imageUrl;
    private int year;
    private boolean isFavorite;

}
