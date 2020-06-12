package com.bcc.gridmenuview.model;

import android.graphics.drawable.Drawable;

public class MenuItem {
    private String title;
    private String imageUri;
    private Drawable image;

    public MenuItem(String title, Drawable image){
        this.title = title;
        this.image = image;
    }

    public MenuItem(String title, String imageUri){
        this.title = title;
        this.imageUri = imageUri;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getImage() {
        return image;
    }

    public String getImageUri() {
        return imageUri;
    }
}
