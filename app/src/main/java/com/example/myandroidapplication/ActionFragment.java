package com.example.myandroidapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myandroidapplication.model.Movie;
import com.example.myandroidapplication.recycler.MovieAdapter;

import java.util.List;

public class ActionFragment extends Fragment implements MovieAdapter.MovieOnClickListener {
    RecyclerView recyclerView;
    List<Movie> movieArrayList;
    public ActionFragment(List<Movie> movieList) {
        movieArrayList = movieList;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_action, container, false);
        recyclerView = view.findViewById(R.id.tab_layout_action);
        MovieAdapter movieAdapter = new MovieAdapter(movieArrayList,getContext(),this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(movieAdapter);
        return view;
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getContext(),MovieDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("MovieObject",movieArrayList.get(position));
        intent.putExtras(bundle);
//        intent.putExtra("image",movieArrayList.get(position).getfImage());
//        intent.putExtra("title",movieArrayList.get(position).getfName());
        startActivity(intent);

    }
}