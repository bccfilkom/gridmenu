package com.bcc.gridmenuview.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import com.bcc.gridmenuview.provider.ImageProvider;

import java.lang.ref.WeakReference;

public class LocalImageTask extends AsyncTask<String, Void, Drawable> {

    private Drawable drawable;
    private ImageProvider imageProvider;
    private final WeakReference<Context> contextWeakReference;


    public LocalImageTask(Context context, ImageProvider imageProvider) {
        this.contextWeakReference = new WeakReference<>(context);
        this.imageProvider = imageProvider;
    }

    @Override
    protected Drawable doInBackground(String... urls) {
        String filePath = urls[0];
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeFile(filePath);
            drawable = new BitmapDrawable(contextWeakReference.get().getResources(), bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return drawable;
    }

    @Override
    protected void onPostExecute(Drawable drawable) {
        super.onPostExecute(drawable);
        imageProvider.onPostExecute(drawable);
    }
}
