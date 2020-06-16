package com.bcc.gridmenuview.component;

import android.widget.ImageView;

import com.bcc.gridmenuview.R;

public class Square extends Shape {

    private ImageView menuItem;
    private ImageView menuItemOverlay;

    public Square(ImageView menuItem, ImageView menuItemOverlay) {
        this.menuItem = menuItem;
        this.menuItemOverlay = menuItemOverlay;
    }

    @Override
    public void setShapeAttributes() {
        menuItem.setImageResource(R.drawable.square);
        menuItemOverlay.setImageResource(R.drawable.square_ripple);
    }
}
