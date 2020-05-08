package com.example.mymovieapplication.data;

import com.example.mymovieapplication.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieSource {
    public static List<Movie> generateMovieListItems(){
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("The Meg","None","Horror",2018));
        list.add(new Movie("Avengers","None","Fantasy",2019));
        list.add(new Movie("Deadpool","None","Comedy",2016));
        return list;
    }
}
