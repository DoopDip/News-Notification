package com.adv.newsnotification;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    private TextView textViewNews;
    private TextView textViewPolitical;
    private TextView textViewTechnology;
    private TextView textViewEntertainment;
    private TextView textViewEducation;
    private TextView textViewCriminal;
    private TextView textViewSport;
    private TextView textViewSocial;


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewNews = (TextView) view.findViewById(R.id.category_news);
        textViewNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListNewsActivity.class);
                intent.putExtra("newsType", SelectNews.NEWS_NEWS);
                startActivity(intent);
            }
        });

        textViewPolitical = (TextView) view.findViewById(R.id.category_political);
        textViewPolitical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListNewsActivity.class);
                intent.putExtra("newsType", SelectNews.POLITICAL_NEWS);
                startActivity(intent);
            }
        });

        textViewTechnology = (TextView) view.findViewById(R.id.category_technology);
        textViewTechnology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListNewsActivity.class);
                intent.putExtra("newsType", SelectNews.TECHNOLOGY_NEWS);
                startActivity(intent);
            }
        });

        textViewEntertainment = (TextView) view.findViewById(R.id.category_entertainment);
        textViewEntertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListNewsActivity.class);
                intent.putExtra("newsType", SelectNews.ENTERTAINMENT_NEWS);
                startActivity(intent);
            }
        });

        textViewEducation = (TextView) view.findViewById(R.id.category_education);
        textViewEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListNewsActivity.class);
                intent.putExtra("newsType", SelectNews.EDUCATION_NEWS);
                startActivity(intent);
            }
        });

        textViewCriminal = (TextView) view.findViewById(R.id.category_criminal);
        textViewCriminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListNewsActivity.class);
                intent.putExtra("newsType", SelectNews.CRIMINAL_NEWS);
                startActivity(intent);
            }
        });

        textViewSport = (TextView) view.findViewById(R.id.category_sport);
        textViewSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListNewsActivity.class);
                intent.putExtra("newsType", SelectNews.SPORT_NEWS);
                startActivity(intent);
            }
        });

        textViewSocial = (TextView) view.findViewById(R.id.category_social);
        textViewSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListNewsActivity.class);
                intent.putExtra("newsType", SelectNews.SOCIAL_NEWS);
                startActivity(intent);
            }
        });

    }
}
