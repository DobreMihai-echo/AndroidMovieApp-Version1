package com.example.myandroidapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myandroidapplication.model.Movie;

import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {
    int nrOfTables;
    List<Movie> movieList;
    public PagerAdapter(FragmentManager fm,int nrOfTables,List<Movie> movies) {
        super(fm);
        this.nrOfTables = nrOfTables;
        movieList = movies;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new ActionFragment(movieList);
            case 1: return new DramaFragment(movieList);
            case 2: return new ComedyFragment(movieList);
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return nrOfTables;
    }
}
