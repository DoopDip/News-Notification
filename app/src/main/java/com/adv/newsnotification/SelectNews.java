package com.adv.newsnotification;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by narit on 19/11/2017 AD.
 */

public class SelectNews {

    private static final String URL = "http://10.5.50.10:8888/newsnotification/json_news.php?";

    //Type news
    public static final int ALL_NEWS = 0;
    public static final int NEWS_NEWS = 1;
    public static final int POLITICAL_NEWS = 2;
    public static final int TECHNOLOGY_NEWS = 3;
    public static final int ENTERTAINMENT_NEWS = 4;
    public static final int EDUCATION_NEWS = 5;
    public static final int CRIMINAL_NEWS = 6;
    public static final int SPORT_NEWS = 7;
    public static final int SOCIAL_NEWS = 8;

    public static final int NO_ID = 0;


    public static List<News> listNews(int typeNews, int idNews) {

        // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        String urlOption = "";
        if (idNews == 0)
            urlOption = "type="+typeNews;
        else
            urlOption = "id="+idNews;


        getHttp http = new getHttp();
        List<News> news = null;
        try {
            news = http.run(URL+""+urlOption);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return news ;
    }

    public static class getHttp {
        OkHttpClient client = new OkHttpClient();
        List<News> news = new ArrayList<>();

        List<News> run(String url) throws IOException, JSONException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            JSONArray array = new JSONArray(response.body().string());

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                news.add(new News(object.getInt("id"),object.getString("title"),object.getString("image"),object.getString("content"), object.getInt("type")));
            }
            return news;
        }
    }

}
