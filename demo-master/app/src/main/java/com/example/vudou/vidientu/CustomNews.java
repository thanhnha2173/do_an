package com.example.vudou.vidientu;

/**
 * Created by vudou on 7/26/2017.
 */

public class CustomNews {
    private int picRes;
    private String title, decr;

    public CustomNews() {
    }

    public CustomNews(int picRes, String title, String decr) {
        this.picRes = picRes;
        this.title = title;
        this.decr = decr;
    }

    public int getPicRes() {
        return picRes;
    }

    public void setPicRes(int picRes) {
        this.picRes = picRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDecr() {
        return decr;
    }

    public void setDecr(String decr) {
        this.decr = decr;
    }
}
