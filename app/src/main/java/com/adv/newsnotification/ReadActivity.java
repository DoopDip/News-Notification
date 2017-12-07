package com.adv.newsnotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        Bundle bundle = getIntent().getExtras();
        String idNews = bundle.getString("newsId");
        Log.d("idNews","="+idNews);

        List<News> news = SelectNews.listNews(SelectNews.ALL_NEWS, Integer.parseInt(idNews));

        TextView textViewTitle = (TextView) findViewById(R.id.read_title);
        textViewTitle.setText(news.get(0).title);

        ImageView imageView = (ImageView) findViewById(R.id.read_image);
        Picasso.with(this).load(news.get(0).image).into(imageView);

        TextView textViewContent = (TextView) findViewById(R.id.read_content);
        textViewContent.setText(news.get(0).content);

    }
}
