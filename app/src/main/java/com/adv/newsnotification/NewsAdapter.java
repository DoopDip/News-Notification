package com.adv.newsnotification;

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

import com.github.florent37.picassopalette.PicassoPalette;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by narit on 15/11/2017 AD.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    public static final String TAG_NEWS = "ข่าวเศรษกิจ";
    public static final String TAG_POLITICAL = "ข่าวการเมือง";
    public static final String TAG_TECHNOLOGY = "ข่าวเทคโนโลยี";
    public static final String TAG_ENTERTAINMENT = "ข่าวบันเทิง";
    public static final String TAG_EDUCATION = "ข่าวการศึกษา";
    public static final String TAG_CRIMINAL = "ข่าวอาชญากรรม";
    public static final String TAG_SPORT = "ข่าวกีฬา";
    public static final String TAG_SOCIAL = "ข่าวสังคม";

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

        holder.textViewType.setText(tagsName(news.type));

        Picasso.with(holder.imageView.getContext()).load(news.image).error(R.drawable.no_image).into(holder.imageView,
                PicassoPalette.with(news.image,holder.imageView)
                        .use(PicassoPalette.Profile.VIBRANT)
                            .intoBackground(holder.textViewTitle)
                            .intoTextColor(holder.textViewTitle)
                            .intoBackground(holder.textViewType)
                            .intoTextColor(holder.textViewType)
                        .use(PicassoPalette.Profile.VIBRANT_DARK)
                            .intoBackground(holder.textViewTitle, PicassoPalette.Swatch.RGB)
                            .intoTextColor(holder.textViewTitle, PicassoPalette.Swatch.BODY_TEXT_COLOR)
                            .intoBackground(holder.textViewType, PicassoPalette.Swatch.RGB)
                            .intoTextColor(holder.textViewType, PicassoPalette.Swatch.BODY_TEXT_COLOR)
                );
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
                    intent.putExtra("newsId", String.valueOf(newsId));
                    context.startActivity(intent);
                }
            });
        }
    }

    //SHOW Tag Name
    public static String tagsName(int tag) {
        if (tag == 1)
            return TAG_NEWS;
        else if (tag == 2)
            return TAG_POLITICAL;
        else if (tag == 3)
            return TAG_TECHNOLOGY;
        else if (tag == 4)
            return TAG_ENTERTAINMENT;
        else if (tag == 5)
            return TAG_EDUCATION;
        else if (tag == 6)
            return TAG_CRIMINAL;
        else if (tag == 7)
            return TAG_SPORT;
        else if (tag == 8)
            return TAG_SOCIAL;
        return "Tags Error";
    }

}
