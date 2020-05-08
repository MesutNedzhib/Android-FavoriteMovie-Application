package com.example.mymovieapplication.intr;

import com.example.mymovieapplication.model.Movie;

import java.util.List;

public interface MovieFunctionsInterface {
    List<Movie> getAllMovies();
    void movieRatingChange(int index,int rating);
    void addMovies(List<Movie> movies);
    void addMovie(Movie movie);
    void deleteMovie(int index);
}
