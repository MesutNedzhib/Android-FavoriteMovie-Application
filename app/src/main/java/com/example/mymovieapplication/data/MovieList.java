package com.example.mymovieapplication.data;

import com.example.mymovieapplication.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieList {
    private List<Movie> movies = new ArrayList<>();
    public List<Movie> getAllMovies(){
        return movies;
    }

}
