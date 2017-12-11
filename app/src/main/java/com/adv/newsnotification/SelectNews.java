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

public class SelectNews {

    private static final String URL_HOST = "http://10.5.50.10:8888/newsnotification";
    private static final String URL_GET_JSON = URL_HOST+"/json_news.php?";
    private static final String URL_IMAGE = URL_HOST+"/image/";

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
            news = http.run(URL_GET_JSON+""+urlOption);
        } catch (IOException e) {
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
                String image = URL_IMAGE+object.getString("image");
                news.add(new News(
                        object.getInt("id"),
                        object.getString("title"),
                        image,
                        object.getString("content"),
                        object.getInt("type")
                ));
            }
            return news;
        }
    }


    private List<News> fakeNews() {
        List<News> news = new ArrayList<>();
        news.add(new News(1,"“แมวจรจัด” ผู้ต้องสงสัยฆาตกรรมยายชาวญี่ปุ่นวัย 82 ปี","https://i.imgur.com/Jvh1OQm.jpg","ตำรวจญี่ปุ่นทำการสอบสวนคดีฆาตกรรมหญิงสูงวัยรายหนึ่ง โดยพบผู้ต้องสงสัยในคดีนี้ได้ ซึ่งไม่น่าจะเป็นไปได้ นั่นคือ แมวจรจัด\n" + "\n" +
                "สำนักข่าวต่างประเทศรายงานว่า ตำรวจญี่ปุ่นได้รับแจ้งเหตุ นางมายูโกะ มัตสึโมโตะ อายุ 82 ปี ที่ไม่สามารถพูดได้ กลายเป็นศพเสียชีวิตปริศนาที่บ้าน ทางตอนใต้ของประเทศญี่ปุ่น โดยใบหน้าของเธอเต็มไปด้วยเลือด และมีแผลกว่า 20 แห่ง\n" +
                "\n" +
                "ตำรวจไม่พบหลักฐานว่ามีคนแปลกหน้าเข้าและออกจากบ้านผู้เสียชีวิตในเวลาที่คาดว่าเป็นช่วงเกิดเหตุ ต่อมาพวกเขาสังเกตเห็นบาดแผลบนหน้าของนางมัตสึโมโตะ ทำให้นึกขึ้นได้ว่าคล้ายรอยข่วนของแมว\n" +
                "\n" +
                "จึงหันมาเฝ้าติดตามแมวจรจดที่เดินรอบๆ บ้านของนางมัตสึโมโตะ และพบร่องรอยบางสิ่งเป็นเลือดมนุษย์จากแมวตัวหนึ่ง โดยตอนนี้ทางตำรวจกำลังนำตัวอย่างเลือดที่นำมาจากแมวตัวดังกล่าวไปตรวจสอบ ว่าเป็นของหญิงชราวัย 82 ปีหรือไม่\n" +
                "\n" +
                "อย่างไรก็ตามโฆษกตำรวจปฏิเสธที่จะให้ข้อมูลเกี่ยวกับคดีนี้ แต่ก็ไม่ได้โต้แย้งประเด็นที่สื่อนำเสนอแต่อย่างใด", 1));
        news.add(new News(2,"title2","https://i.imgur.com/3rYHhEu.jpg","content2", 1));
        news.add(new News(3,"title3","https://i.imgur.com/CMHoA7C.jpg","content3", 2));
        news.add(new News(4,"title4","https://i.imgur.com/pIUsuyE.jpg","content4", 4));
        news.add(new News(5,"title5","https://i.imgur.com/B0D4iRk.jpg","content5", 1));
        news.add(new News(6,"title6","https://i.imgur.com/Jvh1OQm.jpg","content6", 5));
        news.add(new News(7,"title7","https://i.imgur.com/3rYHhEu.jpg","content7", 8));
        news.add(new News(8,"title8","https://i.imgur.com/CMHoA7C.jpg","content8", 2));
        news.add(new News(9,"title9","https://i.imgur.com/pIUsuyE.jpg","content9", 7));
        news.add(new News(10,"title10","https://i.imgur.com/B0D4iRk.jpg","content10", 1));

        return news;
    }

}
