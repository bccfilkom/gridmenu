package com.bcc.gridmenuview.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import com.bcc.gridmenuview.provider.ImageProvider;

import java.io.InputStream;
import java.lang.ref.WeakReference;

public class NetworkImageTask extends AsyncTask<String, Void, Drawable> {

    private Drawable drawable;
    private ImageProvider imageProvider;
    private final WeakReference<Context> context;


    public NetworkImageTask(Context context, ImageProvider imageProvider) {
        this.context = new WeakReference<>(context);
        this.imageProvider = imageProvider;
    }

    @Override
    protected Drawable doInBackground(String... urls) {
        String url = urls[0];
        Bitmap bitmap;
        try {
            InputStream srt = new java.net.URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(srt);
            drawable = new BitmapDrawable(context.get().getResources(), bitmap);
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
