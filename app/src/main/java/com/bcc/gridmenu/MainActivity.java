package com.bcc.gridmenu;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bcc.gridmenuview.GridMenu;
import com.bcc.gridmenuview.event.OnItemClickListener;
import com.bcc.gridmenuview.model.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("satu", getResources().getDrawable(R.mipmap.ic_launcher_round)));
        list.add(new MenuItem("dua", getResources().getDrawable(R.mipmap.ic_launcher_round)));
        list.add(new MenuItem("tiga", getResources().getDrawable(R.mipmap.ic_launcher_round)));
        list.add(new MenuItem("satu", getResources().getDrawable(R.mipmap.ic_launcher_round)));
        list.add(new MenuItem("dua", getResources().getDrawable(R.mipmap.ic_launcher_round)));
        list.add(new MenuItem("tiga", getResources().getDrawable(R.mipmap.ic_launcher_round)));

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
