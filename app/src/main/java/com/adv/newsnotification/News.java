package com.adv.newsnotification;

public class News {

    public int id;
    public String title;
    public String image;
    public String content;
    public int type;

    public News(int id, String title, String image, String content, int type) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.type = type;
    }
}
