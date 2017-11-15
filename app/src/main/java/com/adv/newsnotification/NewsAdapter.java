package com.adv.newsnotification;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by narit on 15/11/2017 AD.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private List<News> list;

    public NewsAdapter(List<News> list) {
        this.list = list;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        News news = list.get(position);
        holder.textView.setText(news.title);

        Picasso.with(holder.imageView.getContext()).load(news.image).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class NewsHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public NewsHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.listNews_image);
            textView = (TextView) itemView.findViewById(R.id.listNews_title);
        }
    }
}
