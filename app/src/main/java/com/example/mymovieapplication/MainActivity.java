package com.example.mymovieapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mymovieapplication.adapter.MovieAdapter;
import com.example.mymovieapplication.data.MovieList;
import com.example.mymovieapplication.data.MovieSource;
import com.example.mymovieapplication.fragment.AddMovieDialogFragment;
import com.example.mymovieapplication.intr.MovieDialogFragmentListener;
import com.example.mymovieapplication.intr.MovieInterfaceFunctions;
import com.example.mymovieapplication.intr.MovieFunctionsInterface;
import com.example.mymovieapplication.intr.MovieRatingChangeListener;
import com.example.mymovieapplication.model.Movie;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements MovieRatingChangeListener, MovieDialogFragmentListener {

    private RecyclerView recyclerView;
    MovieFunctionsInterface functions;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovieList movieList = new MovieList();

        functions = new MovieInterfaceFunctions(movieList);
        functions.addMovies(MovieSource.generateMovieListItems());

        recyclerView = findViewById(R.id.recyclerView);

        adapter = new MovieAdapter(functions.getAllMovies(),  this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(x -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            AddMovieDialogFragment dialogFragment = AddMovieDialogFragment.newInstance();
            dialogFragment.show(fragmentManager,"fragment_add_movie");
        });

        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder target, int direction) {
                int position = target.getAdapterPosition();
                functions.deleteMovie(position);
                adapter.notifyDataSetChanged();
            }
        });
        touchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void movieRatingChange(int index, int rating) {
        functions.movieRatingChange(index,rating);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void addMovie(Movie movie) {
        functions.addMovie(movie);
        adapter.notifyDataSetChanged();
    }
}