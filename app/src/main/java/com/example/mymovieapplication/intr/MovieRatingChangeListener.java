package com.example.mymovieapplication.intr;

import com.example.mymovieapplication.model.Movie;

import java.util.List;

public interface MovieRatingChangeListener {
    void movieRatingChange(int index,int rating);
}
