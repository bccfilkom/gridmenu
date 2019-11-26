package com.bcc.opensource.squaremenu;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class SquareMenuAdapterTest {

    private SquareMenuAdapter squareMenuAdapter;

    @Before
    public void setUp(){
        squareMenuAdapter = new SquareMenuAdapter();
    }

    @Test
    public void constructorShouldNotReturnNull(){
        assertNotNull(squareMenuAdapter);
    }

    @Test
    public void sizeShouldReturnThreeAfterAddThreeItem(){
        ArrayList<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("satu", InstrumentationRegistry.getInstrumentation().
                getContext().getResources().getDrawable(R.drawable.ic_launcher_background)));
        list.add(new MenuItem("dua", InstrumentationRegistry.getInstrumentation().
                getContext().getResources().getDrawable(R.drawable.ic_launcher_background)));
        list.add(new MenuItem("tiga", InstrumentationRegistry.getInstrumentation().
                getContext().getResources().getDrawable(R.drawable.ic_launcher_background)));
        squareMenuAdapter.setMenuItems(list);
        assertEquals(squareMenuAdapter.getItemCount(),3);
    }






}