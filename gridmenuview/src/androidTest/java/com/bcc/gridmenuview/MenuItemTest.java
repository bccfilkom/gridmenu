package com.bcc.gridmenuview;
import android.graphics.drawable.Drawable;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuItemTest  {
    private MenuItem  menuItem;

    @Before
    public void setUp()  {
        menuItem = new MenuItem("Satu",InstrumentationRegistry
                .getInstrumentation()
                .getContext()
                .getDrawable(R.drawable.ic_launcher_background));

    }

    @Test
    public void menuItemNotNull(){
        assertNotNull(menuItem);
    }

    @Test
    public void menuGetTitleShouldReturnString() {
        assertEquals("Satu", menuItem.getTitle());
    }

    @Test
    public void getImage()  {
        Drawable image =  InstrumentationRegistry
                .getInstrumentation()
                .getContext()
                .getDrawable(R.drawable.ic_launcher_background);
        if (image!=null) {
            assertEquals(menuItem.getImage()
                    .getConstantState(), image.getConstantState());
        }
    }
}
