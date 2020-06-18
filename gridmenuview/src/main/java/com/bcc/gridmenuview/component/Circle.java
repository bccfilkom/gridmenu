package com.bcc.gridmenuview.component;

import android.graphics.PorterDuff;
import android.widget.ImageView;

import com.bcc.gridmenuview.R;
import com.christophesmet.android.views.maskableframelayout.MaskableFrameLayout;

public class Circle extends Shape {

    private ImageView menuItemOverlay;
    private MaskableFrameLayout maskableFrameLayout;

    public Circle(MaskableFrameLayout maskableFrameLayout, ImageView menuItemOverlay) {
        this.maskableFrameLayout = maskableFrameLayout;
        this.menuItemOverlay = menuItemOverlay;
    }

    @Override
    public void shapeOverlay() {
        menuItemOverlay.setImageResource(R.drawable.circle_ripple);
    }

    @Override
    public void maskShape() {
        maskableFrameLayout.setMask(R.drawable.circle);
        maskableFrameLayout.setPorterDuffXferMode(PorterDuff.Mode.DST_IN);
    }
}
