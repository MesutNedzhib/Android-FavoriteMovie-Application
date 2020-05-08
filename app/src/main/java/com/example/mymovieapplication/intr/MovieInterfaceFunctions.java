package com.example.mymovieapplication.intr;

import com.example.mymovieapplication.data.MovieList;
import com.example.mymovieapplication.model.Movie;

import java.util.List;

public class MovieInterfaceFunctions implements MovieFunctionsInterface {
    MovieList list;

    public MovieInterfaceFunctions(MovieList list){
        this.list=list;
    }

    @Override
    public List<Movie> getAllMovies() {
        return list.getAllMovies();
    }

    @Override
    public void movieRatingChange(int index, int rating) {
        list.getAllMovies().get(index).setRating(rating);
    }

    @Override
    public void addMovies(List<Movie> movies) {
        list.getAllMovies().addAll(movies);
    }

    @Override
    public void addMovie(Movie movie) {
        list.getAllMovies().add(movie);
    }

    @Override
    public void deleteMovie(int index) {
        list.getAllMovies().remove(index);
    }
}
