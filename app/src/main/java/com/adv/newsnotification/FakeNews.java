package com.adv.newsnotification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by narit on 16/11/2017 AD.
 */

public class FakeNews {

    public static List<News> listNews() {

        //Fake News
        List<News> news = new ArrayList<>();
        news.add(new News(1,"“แมวจรจัด” ผู้ต้องสงสัยฆาตกรรมยายชาวญี่ปุ่นวัย 82 ปี","https://i.imgur.com/Jvh1OQm.jpg","ตำรวจญี่ปุ่นทำการสอบสวนคดีฆาตกรรมหญิงสูงวัยรายหนึ่ง โดยพบผู้ต้องสงสัยในคดีนี้ได้ ซึ่งไม่น่าจะเป็นไปได้ นั่นคือ แมวจรจัด\n" +
                "\n" +
                "สำนักข่าวต่างประเทศรายงานว่า ตำรวจญี่ปุ่นได้รับแจ้งเหตุ นางมายูโกะ มัตสึโมโตะ อายุ 82 ปี ที่ไม่สามารถพูดได้ กลายเป็นศพเสียชีวิตปริศนาที่บ้าน ทางตอนใต้ของประเทศญี่ปุ่น โดยใบหน้าของเธอเต็มไปด้วยเลือด และมีแผลกว่า 20 แห่ง\n" +
                "\n" +
                "ตำรวจไม่พบหลักฐานว่ามีคนแปลกหน้าเข้าและออกจากบ้านผู้เสียชีวิตในเวลาที่คาดว่าเป็นช่วงเกิดเหตุ ต่อมาพวกเขาสังเกตเห็นบาดแผลบนหน้าของนางมัตสึโมโตะ ทำให้นึกขึ้นได้ว่าคล้ายรอยข่วนของแมว\n" +
                "\n" +
                "จึงหันมาเฝ้าติดตามแมวจรจดที่เดินรอบๆ บ้านของนางมัตสึโมโตะ และพบร่องรอยบางสิ่งเป็นเลือดมนุษย์จากแมวตัวหนึ่ง โดยตอนนี้ทางตำรวจกำลังนำตัวอย่างเลือดที่นำมาจากแมวตัวดังกล่าวไปตรวจสอบ ว่าเป็นของหญิงชราวัย 82 ปีหรือไม่\n" +
                "\n" +
                "อย่างไรก็ตามโฆษกตำรวจปฏิเสธที่จะให้ข้อมูลเกี่ยวกับคดีนี้ แต่ก็ไม่ได้โต้แย้งประเด็นที่สื่อนำเสนอแต่อย่างใด", 1));
        news.add(new News(2,"title2","https://i.imgur.com/3rYHhEu.jpg","content2", 1));
        news.add(new News(3,"title3","https://i.imgur.com/CMHoA7C.jpg","content3", 1));
        news.add(new News(4,"title4","https://i.imgur.com/pIUsuyE.jpg","content4", 1));
        news.add(new News(5,"title5","https://i.imgur.com/B0D4iRk.jpg","content5", 1));
        news.add(new News(6,"title6","https://i.imgur.com/Jvh1OQm.jpg","content6", 1));
        news.add(new News(7,"title7","https://i.imgur.com/3rYHhEu.jpg","content7", 1));
        news.add(new News(8,"title8","https://i.imgur.com/CMHoA7C.jpg","content8", 1));
        news.add(new News(9,"title9","https://i.imgur.com/pIUsuyE.jpg","content9", 1));
        news.add(new News(10,"title10","https://i.imgur.com/B0D4iRk.jpg","content10", 1));

        return news;
    }
}
