package com.bcc.gridmenuview.provider;

import android.graphics.drawable.Drawable;

public interface ImageProvider {

    Drawable getDrawable();

    void onPostExecute(Drawable drawable);

}
