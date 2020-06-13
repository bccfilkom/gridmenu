package com.bcc.gridmenuview.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.bcc.gridmenuview.task.NetworkImageTask;

import java.util.concurrent.ExecutionException;

public class NetworkImageProvider implements ImageProvider {

    private Drawable drawable;
    private String path;

    public NetworkImageProvider(Context context, String url) {
        this.path = url;
        try {
            new NetworkImageTask(this, context).execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Drawable getDrawable() {
        return drawable;
    }

    @Override
    public void onPostExecute(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getPath() {
        return path;
    }
}
