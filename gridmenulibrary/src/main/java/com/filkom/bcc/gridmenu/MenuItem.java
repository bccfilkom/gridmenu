package com.filkom.bcc.gridmenu;

import android.graphics.drawable.Drawable;

public class MenuItem {
    private String title;
    private Drawable image;

    public MenuItem(String title, Drawable image){
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getImage() {
        return image;
    }
}
