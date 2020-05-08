package com.example.mymovieapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymovieapplication.R;
import com.example.mymovieapplication.intr.MovieRatingChangeListener;
import com.example.mymovieapplication.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private MovieRatingChangeListener listener;

    public MovieAdapter(List<Movie> movie, MovieRatingChangeListener listener){
        this.movies=movie;
        this.listener=listener;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView director;
        TextView genre;
        TextView year;

        ImageView star1;
        ImageView star2;
        ImageView star3;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movieTextView);
            director = itemView.findViewById(R.id.directorTextView);
            genre = itemView.findViewById(R.id.genreTextView);
            year = itemView.findViewById(R.id.yearTextView);

            star1 = itemView.findViewById(R.id.star1);
            star2 = itemView.findViewById(R.id.star2);
            star3 = itemView.findViewById(R.id.star3);
        }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        final Movie movie = movies.get(position);

        holder.title.setText(movie.getTitle());
        holder.director.setText(movie.getDirector());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(String.valueOf(movie.getYear()));

        holder.star1.setOnClickListener(l -> {
            if (movie.getRating() != 1)
               MovieAdapter.this.listener.movieRatingChange(position, 1);
        });

        holder.star2.setOnClickListener(l -> {
            if (movie.getRating() != 2)
                MovieAdapter.this.listener.movieRatingChange(position, 2);
        });

        holder.star3.setOnClickListener(l -> {
            if (movie.getRating() != 3)
                MovieAdapter.this.listener.movieRatingChange(position, 3);
        });

        switch (movie.getRating()) {
            case 1:
                holder.star1.setImageResource(R.drawable.full);
                holder.star2.setImageResource(R.drawable.empty);
                holder.star3.setImageResource(R.drawable.empty);
                break;
            case 2:
                holder.star1.setImageResource(R.drawable.full);
                holder.star2.setImageResource(R.drawable.full);
                holder.star3.setImageResource(R.drawable.empty);
                break;
            case 3:
                holder.star1.setImageResource(R.drawable.full);
                holder.star2.setImageResource(R.drawable.full);
                holder.star3.setImageResource(R.drawable.full);
                break;
            default:
                holder.star1.setImageResource(R.drawable.empty);
                holder.star2.setImageResource(R.drawable.empty);
                holder.star3.setImageResource(R.drawable.empty);
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
