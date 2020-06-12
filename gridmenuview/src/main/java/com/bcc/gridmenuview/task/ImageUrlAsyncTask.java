package com.bcc.gridmenuview.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageUrlAsyncTask extends AsyncTask<Object, Integer, Drawable> {
    Drawable image;
    HttpURLConnection connection;

    @Override
    protected Drawable doInBackground(Object... params) {
        try {
            URL url = new URL((String) params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            image = new BitmapDrawable(((Context) params[1]).getResources(), bitmap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return image;
    }

    @Override
    protected void onPostExecute(Drawable drawable) {
        super.onPostExecute(drawable);
        image = drawable;
    }
}
