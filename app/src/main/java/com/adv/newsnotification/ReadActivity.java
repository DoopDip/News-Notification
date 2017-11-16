package com.adv.newsnotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);



        List<News> news = FakeNews.listNews();

        Bundle bundle = getIntent().getExtras();
        int idNews = bundle.getInt("newsId")-1;

        TextView textViewTitle = (TextView) findViewById(R.id.read_title);
        textViewTitle.setText(news.get(idNews).title);

        ImageView imageView = (ImageView) findViewById(R.id.read_image);
        Picasso.with(this).load(news.get(idNews).image).into(imageView);

        TextView textViewContent = (TextView) findViewById(R.id.read_content);
        textViewContent.setText(news.get(idNews).content);

    }
}
