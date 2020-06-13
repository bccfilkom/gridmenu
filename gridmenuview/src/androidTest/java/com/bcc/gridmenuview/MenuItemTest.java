package com.bcc.gridmenuview;

import android.graphics.drawable.Drawable;

import androidx.test.platform.app.InstrumentationRegistry;

import com.bcc.gridmenuview.model.MenuItem;
import com.bcc.gridmenuview.provider.DrawableImageProvider;
import com.bcc.gridmenuview.provider.LocalImageProvider;
import com.bcc.gridmenuview.provider.NetworkImageProvider;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MenuItemTest {

    private MenuItem menuItemDrawable;
    private MenuItem menuItemURL;
    private MenuItem menuItemLocal;
    private DrawableImageProvider drawableImageProvider;
    private NetworkImageProvider networkImageProvider;
    private LocalImageProvider localImageProvider;

    @Before
    public void setUpMenuItemDrawable() {
        drawableImageProvider = new DrawableImageProvider(InstrumentationRegistry
                .getInstrumentation()
                .getContext()
                .getDrawable(R.drawable.ic_launcher_background));
        menuItemDrawable = new MenuItem("Satu", drawableImageProvider);
    }

    @Before
    public void setUpMenuItemURL() {
        networkImageProvider = new NetworkImageProvider(InstrumentationRegistry.getInstrumentation().getContext(), "https://cdn3.iconfinder.com/data/icons/capsocial-round/500/youtube3-128.png");
        menuItemURL = new MenuItem("Satu", networkImageProvider);
    }

    @Before
    public void setUpMenuItemLocal() {
        localImageProvider = new LocalImageProvider(InstrumentationRegistry.getInstrumentation().getContext(), "/storage/emulated/0/DCIM/Camera/test.jpg");
        menuItemLocal = new MenuItem("Satu", localImageProvider);
    }

    @Test
    public void drawableImageProviderNotNull() {
        assertNotNull(drawableImageProvider);
    }

    @Test
    public void networkImageProviderNotNull() {
        assertNotNull(networkImageProvider);
    }

    @Test
    public void localImageProviderNotNull() {
        assertNotNull(localImageProvider);
    }

    @Test
    public void menuItemDrawableNotNull() {
        assertNotNull(menuItemDrawable);
    }

    @Test
    public void menuItemURLNotNull() {
        assertNotNull(menuItemURL);
    }

    @Test
    public void menuItemLocalNotNull() {
        assertNotNull(menuItemLocal);
    }

    @Test
    public void menuGetTitleShouldReturnString() {
        assertEquals("Satu", menuItemDrawable.getTitle());
    }

    @Test
    public void drawableNotNull() {
        Drawable image = InstrumentationRegistry
                .getInstrumentation()
                .getContext()
                .getDrawable(R.drawable.ic_launcher_background);
        if (image != null) {
            assertEquals(image.getConstantState(), menuItemDrawable.getDrawable()
                    .getConstantState());
        }
    }

    @Test
    public void pathURLNotNull() {
        assertEquals("https://cdn3.iconfinder.com/data/icons/capsocial-round/500/youtube3-128.png", networkImageProvider.getPath());
    }

    @Test
    public void pathLocalNotNull() {
        assertEquals("/storage/emulated/0/DCIM/Camera/test.jpg", localImageProvider.getPath());
    }
}
