package com.bcc.gridmenuview.model;

import android.graphics.drawable.Drawable;

import com.bcc.gridmenuview.provider.ImageProvider;

public class MenuItem {
    private String title;
    private ImageProvider imageProvider;

    public MenuItem(String title, ImageProvider imageProvider) {
        this.title = title;
        this.imageProvider = imageProvider;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getDrawable() {
        return imageProvider.getDrawable();
    }
}
