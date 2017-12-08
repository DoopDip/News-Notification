package com.adv.newsnotification;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ListNewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);

        final Bundle bundle = getIntent().getExtras();
        recyclerView = (RecyclerView) findViewById(R.id.listNews_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NewsAdapter(SelectNews.listNews(bundle.getInt("newsType"), SelectNews.NO_ID)));

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.listNews_swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                recyclerView.setAdapter(new NewsAdapter(SelectNews.listNews(bundle.getInt("newsType"), SelectNews.NO_ID)));
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
