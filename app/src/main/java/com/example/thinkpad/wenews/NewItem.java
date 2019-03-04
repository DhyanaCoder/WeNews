package com.example.thinkpad.wenews;

/**
 * Created by thinkpad on 2019/3/2.
 */

public class NewItem {
    private String title;
    private String pictureAddress;
    private String contentAddress;

    public String getContentAddress() {
        return contentAddress;
    }

    public void setContentAddress(String contentAddress) {
        this.contentAddress = contentAddress;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
