package com.example.myandroidapplication.recycler;

import android.content.Context;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroidapplication.R;
import com.example.myandroidapplication.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> fMovies;
    private Context context;
    private MovieOnClickListener movieOnClickListener;

    public MovieAdapter(List<Movie> movies,Context context,MovieOnClickListener movieOnClickListener) {
        fMovies = movies;
        context = context;
        this.movieOnClickListener = movieOnClickListener;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View movieView = inflater.inflate(R.layout.movie_display_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(movieView,movieOnClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Movie movie = fMovies.get(position);
        holder.setItems(movie);
    }

    @Override
    public int getItemCount() {
        return fMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView movieImageView;
        public TextView nameTextView;
        MovieOnClickListener movieOnClickListener;

        public ViewHolder(@NonNull View itemView, MovieOnClickListener movieOnClickListener) {
            super(itemView);
            movieImageView = itemView.findViewById(R.id.movie_display_image);
            nameTextView = itemView.findViewById(R.id.movie_display_name);
            this.movieOnClickListener = movieOnClickListener;
            itemView.setOnClickListener(this);
        }

        public void setItems(Movie movie) {
            movieImageView.setImageResource(movie.getfImage());
            nameTextView.setText(movie.getfName());
        }

        @Override
        public void onClick(View v) {
            movieOnClickListener.onClick(getAdapterPosition());
        }
    }

    public interface MovieOnClickListener {
        public void onClick(int position);
    }
}
