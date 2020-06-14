package com.bcc.gridmenu;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bcc.gridmenuview.GridMenu;
import com.bcc.gridmenuview.event.OnItemClickListener;
import com.bcc.gridmenuview.model.MenuItem;
import com.bcc.gridmenuview.provider.DrawableImageProvider;
import com.bcc.gridmenuview.provider.LocalImageProvider;
import com.bcc.gridmenuview.provider.NetworkImageProvider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawableImageProvider drawableImageProvider = new DrawableImageProvider(getResources().getDrawable(R.drawable.ic_launcher_background));
        NetworkImageProvider networkImageProvider = new NetworkImageProvider(this, "https://cdn3.iconfinder.com/data/icons/capsocial-round/500/youtube3-128.png");
        LocalImageProvider localImageProvider = new LocalImageProvider(this, "/storage/emulated/0/DCIM/Camera/test.jpg");

        final ArrayList<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("satu", getResources().getDrawable(R.drawable.ic_launcher_background)));
        list.add(new MenuItem("dua", drawableImageProvider));
        list.add(new MenuItem("tiga", networkImageProvider));
        list.add(new MenuItem("empat", localImageProvider));

        GridMenu menu = findViewById(R.id.square_menu);
        menu.setMenuItems(list);
        menu.setOnClickListener(new OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, "you selected " + list.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
