package com.example.vudou.vidientu;

/**
 * Created by vudou on 7/26/2017.
 */

public class CustomButton {
    private int picRes;
    private String decr;

    public CustomButton(int picRes, String decr) {
        this.picRes = picRes;
        this.decr = decr;
    }

    public CustomButton() {

    }

    public int getPicRes() {
        return picRes;
    }

    public void setPicRes(int picRes) {
        this.picRes = picRes;
    }

    public String getDecr() {
        return decr;
    }

    public void setDecr(String decr) {
        this.decr = decr;
    }
}
