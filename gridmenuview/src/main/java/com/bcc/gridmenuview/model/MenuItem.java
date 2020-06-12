package com.bcc.gridmenuview.model;

import android.graphics.drawable.Drawable;

public class MenuItem {
    private String title;
    private Drawable image;
    private String url;

    public MenuItem(String title, Drawable image){
        this.title = title;
        this.image = image;
    }

    public MenuItem(String title, String url){
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }
}
