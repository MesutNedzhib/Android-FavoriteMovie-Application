package com.example.mymovieapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.mymovieapplication.R;
import com.example.mymovieapplication.intr.MovieDialogFragmentListener;
import com.example.mymovieapplication.model.Movie;

public class AddMovieDialogFragment extends DialogFragment {

    private EditText title;
    private EditText director;
    private EditText genre;
    private EditText year;

    private Button add_btn;
    private Button cancel_btn;

    MovieDialogFragmentListener listener;

    private AddMovieDialogFragment() {}

    public static AddMovieDialogFragment newInstance(){
      return new AddMovieDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = view.findViewById(R.id.titleEditText);
        director = view.findViewById(R.id.directorEditText);
        genre = view.findViewById(R.id.genreEditText);
        year = view.findViewById(R.id.yearEditText);

        add_btn = view.findViewById(R.id.add_button);
        cancel_btn = view.findViewById(R.id.button2);

        add_btn.setOnClickListener(x ->{

            String add_title = title.getText().toString();
            String add_director = director.getText().toString();
            String add_genre = genre.getText().toString();
            String add_year = year.getText().toString();

            listener = ((MovieDialogFragmentListener)getActivity());

            if(listener!=null){
                listener.addMovie(new Movie(add_title,add_director,add_genre,Integer.parseInt(add_year)));
                dismiss();
            }
        });

        cancel_btn.setOnClickListener(x -> dismiss());

    }
}
