package com.example.myandroidapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.myandroidapplication.model.Cast;
import com.example.myandroidapplication.model.Movie;
import com.example.myandroidapplication.recycler.MovieAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MovieOnClickListener {
    List<Movie> movieArrayList = new ArrayList<>();
    List<Cast> castArrayList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.activity_main_tab_layout);
        ViewPager viewPager = findViewById(R.id.activity_main_tab_layout_view_pager);
        tabLayout.addTab(tabLayout.newTab().setText("Action"));
        tabLayout.addTab(tabLayout.newTab().setText("Comedy"));
        tabLayout.addTab(tabLayout.newTab().setText("Drama"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),movieArrayList);

        RecyclerView recyclerViewForPopMovie = findViewById(R.id.bestAndPopular);
        RecyclerView recyclerViewForNewMovie = findViewById(R.id.activity_main_new_movies_recycler_view);
        castArrayList.add(new Cast(R.drawable.bilyboyd,"Billy","Boyd","Played Pippin"));
        castArrayList.add(new Cast(R.drawable.cateblanchett,"Cate","Blanchett","Played Galadriel"));
        castArrayList.add(new Cast(R.drawable.orlandobloom,"Orlando","Bloom","Played Legolas"));
        castArrayList.add(new Cast(R.drawable.salabaker,"Sala","Baker","Played Sauron"));
        castArrayList.add(new Cast(R.drawable.seanastin,"Sean","Nastin","Played Sam"));
        castArrayList.add(new Cast(R.drawable.seanbean,"Sean","Bean","Played Boromir"));



        for (int i = 0; i <=5; i++) {
            movieArrayList.add(new Movie(R.drawable.lordoftherings,R.drawable.backgroundlotr,"Lord of the Rings","A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",castArrayList));
            movieArrayList.add(new Movie(R.drawable.venom,R.drawable.backgroundvenom2,"Venom 2","Tom Hardy returns to the big screen as the lethal protector Venom, one of MARVEL's greatest and most complex characters. Directed by Andy Serkis, the film also stars Michelle Williams, Naomie Harris and Woody Harrelson, in the role of the villain Cletus Kasady/Carnage.",castArrayList));
        }



        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Popular movie
        MovieAdapter movieAdapter = new MovieAdapter(movieArrayList,this,this);
        recyclerViewForPopMovie.setAdapter(movieAdapter);
        recyclerViewForPopMovie.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        //New movie
        MovieAdapter movieAdapterForNewMovie = new MovieAdapter(movieArrayList,this,this);
        recyclerViewForNewMovie.setAdapter(movieAdapterForNewMovie);
        recyclerViewForNewMovie.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }


    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this,MovieDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("MovieObject",movieArrayList.get(position));
        intent.putExtras(bundle);
//        intent.putExtra("image",movieArrayList.get(position).getfImage());
//        intent.putExtra("title",movieArrayList.get(position).getfName());
        startActivity(intent);

    }
}