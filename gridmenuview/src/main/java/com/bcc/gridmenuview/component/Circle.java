package com.bcc.gridmenuview.component;

import android.widget.ImageView;

import com.bcc.gridmenuview.R;

public class Circle extends Shape {

    private ImageView menuItem;
    private ImageView menuItemOverlay;

    public Circle(ImageView menuItem, ImageView menuItemOverlay) {
        this.menuItem = menuItem;
        this.menuItemOverlay = menuItemOverlay;
    }

    @Override
    public void setShapeAttributes() {
        menuItem.setImageResource(R.drawable.circle);
        menuItemOverlay.setImageResource(R.drawable.circle_ripple);
    }
}
