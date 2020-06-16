package com.bcc.gridmenuview.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.bcc.gridmenuview.task.LocalImageTask;

import java.io.File;
import java.util.concurrent.ExecutionException;

public class LocalImageProvider implements ImageProvider {

    private Drawable drawable;
    private String path;

    public LocalImageProvider(Context context, String filePath) {
        this.path = filePath;
        File file = new File(filePath);
        try {
            new LocalImageTask(context, this).execute(file.getAbsolutePath()).get();
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
