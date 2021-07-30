package com.example.myandroidapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myandroidapplication.model.Cast;
import com.example.myandroidapplication.model.Movie;
import com.example.myandroidapplication.recycler.CastAdapter;

import java.io.Serializable;
import java.util.List;

public class MovieDetailsActivity extends AppCompatActivity {

    ImageView   imageForMovie;
    ImageView   backImage;
    TextView    descriptionForMovie;
    TextView    titleForMovie;
    //List<Cast>  castList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Movie movie = (Movie) bundle.getSerializable("MovieObject");
        setContentView(R.layout.activity_movie_details);

        RecyclerView recyclerView = findViewById(R.id.movie_details_cast_recycleriew);
        imageForMovie       = findViewById(R.id.movie_details_image_for_movie);
        backImage           = findViewById(R.id.movie_details_trailer_for_movie);
        descriptionForMovie = findViewById(R.id.movie_details_description_for_movie);
        titleForMovie       = findViewById(R.id.movie_details_title_of_movie);
        imageForMovie.setImageResource(movie.getfImage());
        backImage.setImageResource(movie.getFbackImg());
        descriptionForMovie.setText(movie.getfDescription());
        titleForMovie.setText(movie.getfName());

        List<Cast> castList = movie.getfListOfCast();

        CastAdapter castAdapter = new CastAdapter(castList,this);
        recyclerView.setAdapter(castAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));


    }
}