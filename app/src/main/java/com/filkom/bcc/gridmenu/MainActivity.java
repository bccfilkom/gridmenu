package com.filkom.bcc.gridmenu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.filkom.bcc.gridmenulibrary.GridMenu;
import com.filkom.bcc.gridmenulibrary.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("satu", getResources().getDrawable(R.drawable.ic_launcher_foreground)));
        list.add(new MenuItem("dua", getResources().getDrawable(R.drawable.ic_launcher_foreground)));
        list.add(new MenuItem("tiga", getResources().getDrawable(R.drawable.ic_launcher_foreground)));
        list.add(new MenuItem("satu", getResources().getDrawable(R.drawable.ic_launcher_foreground)));
        list.add(new MenuItem("dua", getResources().getDrawable(R.drawable.ic_launcher_foreground)));
        list.add(new MenuItem("tiga", getResources().getDrawable(R.drawable.ic_launcher_foreground)));

        GridMenu menu = findViewById(R.id.square_menu);
        menu.setMenuItems(list);
    }
}
