package com.bcc.gridmenuview.provider;

import android.graphics.drawable.Drawable;

public class DrawableImageProvider implements ImageProvider {

    private Drawable drawable;

    public DrawableImageProvider(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public Drawable getDrawable() {
        return drawable;
    }

    @Override
    public void onPostExecute(Drawable drawable) {
        this.drawable = drawable;
    }

}
