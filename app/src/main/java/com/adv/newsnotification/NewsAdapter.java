package com.adv.newsnotification;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
        holder.textViewTitle.setText(news.title);
        holder.newsId = news.id;

        holder.textViewType.setText(""+news.type);

        Picasso.with(holder.imageView.getContext()).load(news.image).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class NewsHolder extends RecyclerView.ViewHolder {

        private Context context;

        public ImageView imageView;
        public TextView textViewTitle;
        public TextView textViewType;
        public RelativeLayout relativeLayout;

        public int newsId;

        public NewsHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.listNews_image);
            textViewTitle = (TextView) itemView.findViewById(R.id.listNews_title);
            textViewType = (TextView) itemView.findViewById(R.id.listNews_type);

            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.listNews_box);
            context = itemView.getContext();
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NewsClick","List:"+getAdapterPosition()+" / NewsID:"+newsId);
                    Intent intent = new Intent(context , ReadActivity.class);
                    intent.putExtra("newsId", newsId);
                    context.startActivity(intent);
                }
            });
        }
    }

}
