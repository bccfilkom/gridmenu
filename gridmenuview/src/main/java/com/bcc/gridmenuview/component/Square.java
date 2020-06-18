package com.bcc.gridmenuview.component;

import android.graphics.PorterDuff;
import android.widget.ImageView;

import com.bcc.gridmenuview.R;
import com.christophesmet.android.views.maskableframelayout.MaskableFrameLayout;

public class Square extends Shape {

    private ImageView menuItemOverlay;
    private MaskableFrameLayout maskableFrameLayout;

    public Square(MaskableFrameLayout maskableFrameLayout, ImageView menuItemOverlay) {
        this.maskableFrameLayout = maskableFrameLayout;
        this.menuItemOverlay = menuItemOverlay;
    }

    @Override
    public void shapeOverlay() {
        menuItemOverlay.setImageResource(R.drawable.square_ripple);
    }

    @Override
    public void maskShape() {
        maskableFrameLayout.setMask(R.drawable.square);
        maskableFrameLayout.setPorterDuffXferMode(PorterDuff.Mode.DST_IN);
    }
}
