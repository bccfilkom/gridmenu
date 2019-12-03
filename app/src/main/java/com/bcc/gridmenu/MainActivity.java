package com.bcc.gridmenu;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bcc.gridmenuview.GridMenu;
import com.bcc.gridmenuview.MenuItem;
import com.bcc.gridmenuview.OnItemClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("satu", getResources().getDrawable(R.drawable.ic_launcher_foreground)));
        list.add(new MenuItem("dua", getResources().getDrawable(R.drawable.ic_launcher_foreground)));
        list.add(new MenuItem("tiga", getResources().getDrawable(R.drawable.ic_launcher_foreground)));
        list.add(new MenuItem("satu", getResources().getDrawable(R.drawable.ic_launcher_foreground)));
        list.add(new MenuItem("dua", getResources().getDrawable(R.drawable.ic_launcher_foreground)));
        list.add(new MenuItem("tiga", getResources().getDrawable(R.drawable.ic_launcher_foreground)));

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
