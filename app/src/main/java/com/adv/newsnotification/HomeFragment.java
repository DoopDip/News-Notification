package com.adv.newsnotification;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    RecyclerView recyclerView;
    List<News> news;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.home_recyclerView);

        news = new ArrayList<>();
        news.add(new News(1,"title1","https://i.imgur.com/Jvh1OQm.jpg","content1", 1));
        news.add(new News(2,"title2","https://i.imgur.com/3rYHhEu.jpg","content2", 1));
        news.add(new News(3,"title3","https://i.imgur.com/CMHoA7C.jpg","content3", 1));
        news.add(new News(4,"title4","https://i.imgur.com/pIUsuyE.jpg","content4", 1));
        news.add(new News(5,"title5","https://i.imgur.com/B0D4iRk.jpg","content5", 1));

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new NewsAdapter(news));


    }
}
