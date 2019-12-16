package com.bcc.gridmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bcc.gridmenuview.model.MenuItem
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        val list = arrayListOf<MenuItem>()
        list.apply {
            add(MenuItem("satu", ContextCompat.getDrawable(applicationContext, R.drawable.ic_launcher_background)))
            add(MenuItem("dua", ContextCompat.getDrawable(applicationContext, R.drawable.ic_launcher_background)))
            add(MenuItem("tiga", ContextCompat.getDrawable(applicationContext, R.drawable.ic_launcher_background)))
            add(MenuItem("empat", ContextCompat.getDrawable(applicationContext, R.drawable.ic_launcher_background)))
            add(MenuItem("lima", ContextCompat.getDrawable(applicationContext, R.drawable.ic_launcher_background)))
            add(MenuItem("enam", ContextCompat.getDrawable(applicationContext, R.drawable.ic_launcher_background)))
        }

        square_menu.setMenuItems(list)
        square_menu.setOnClickListener { position: Int ->
            Toast.makeText(this, "you selected " + list[position].title, Toast.LENGTH_SHORT).show()
        }
    }
}
