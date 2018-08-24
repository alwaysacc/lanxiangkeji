package com.lanxiang.model;

import java.util.Date;

public class News {
    private Integer news_id;

    private String news_title;

    private String news_image;

    private String news_type;

    private String news;

    private String times;

    public Integer getNews_id() {
        return news_id;
    }

    public void setNews_id(Integer news_id) {
        this.news_id = news_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title == null ? null : news_title.trim();
    }

    public String getNews_image() {
        return news_image;
    }

    public void setNews_image(String news_image) {
        this.news_image = news_image == null ? null : news_image.trim();
    }

    public String getNews_type() {
        return news_type;
    }

    public void setNews_type(String news_type) {
        this.news_type = news_type == null ? null : news_type.trim();
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news == null ? null : news.trim();
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}