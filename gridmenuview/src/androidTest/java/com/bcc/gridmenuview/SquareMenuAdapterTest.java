package com.bcc.gridmenuview;

import androidx.test.platform.app.InstrumentationRegistry;

import com.bcc.gridmenuview.adapter.GridMenuAdapter;
import com.bcc.gridmenuview.model.MenuItem;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SquareMenuAdapterTest {

    private GridMenuAdapter squareMenuAdapter;

    @Before
    public void setUp(){
        squareMenuAdapter = new GridMenuAdapter();
    }

    @Test
    public void constructorShouldNotReturnNull(){
        assertNotNull(squareMenuAdapter);
    }

    @Test
    public void sizeShouldReturnThreeAfterAddThreeItem(){
        ArrayList<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("satu", InstrumentationRegistry.
                getInstrumentation().
                getContext().
                getResources().
                getDrawable(R.drawable.ic_launcher_background)));
        list.add(new MenuItem("dua", InstrumentationRegistry
                .getInstrumentation()
                .getContext()
                .getResources()
                .getDrawable(R.drawable.ic_launcher_background)));
        list.add(new MenuItem("tiga", InstrumentationRegistry.getInstrumentation()
                .getContext()
                .getResources()
                .getDrawable(R.drawable.ic_launcher_background)));
        squareMenuAdapter.setMenuItems(list);
        assertEquals(list.size(), squareMenuAdapter.getItemCount());
    }
}
