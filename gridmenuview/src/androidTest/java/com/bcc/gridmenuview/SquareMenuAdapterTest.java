package com.bcc.gridmenuview;

import androidx.test.platform.app.InstrumentationRegistry;

import com.bcc.gridmenuview.adapter.GridMenuAdapter;
import com.bcc.gridmenuview.model.MenuItem;
import com.bcc.gridmenuview.provider.DrawableImageProvider;
import com.bcc.gridmenuview.provider.LocalImageProvider;
import com.bcc.gridmenuview.provider.NetworkImageProvider;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SquareMenuAdapterTest {

    private GridMenuAdapter squareMenuAdapter;
    private DrawableImageProvider drawableImageProvider;
    private NetworkImageProvider networkImageProvider;
    private LocalImageProvider localImageProvider;

    @Before
    public void setUp() {
        squareMenuAdapter = new GridMenuAdapter();
    }

    @Test
    public void constructorShouldNotReturnNull() {
        assertNotNull(squareMenuAdapter);
    }

    @Test
    public void sizeShouldReturnThreeAfterAddThreeItem() {
        drawableImageProvider = new DrawableImageProvider(InstrumentationRegistry
                .getInstrumentation()
                .getContext()
                .getDrawable(R.drawable.ic_launcher_background));

        networkImageProvider = new NetworkImageProvider(InstrumentationRegistry
                .getInstrumentation()
                .getContext(),
                "https://cdn3.iconfinder.com/data/icons/capsocial-round/500/youtube3-128.png");

        localImageProvider = new LocalImageProvider(InstrumentationRegistry
                .getInstrumentation()
                .getContext(),
                "/storage/emulated/0/DCIM/Camera/test.jpg");

        ArrayList<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("satu", InstrumentationRegistry.getInstrumentation().getContext().getDrawable(R.drawable.ic_launcher_background)));
        list.add(new MenuItem("dua", drawableImageProvider));
        list.add(new MenuItem("tiga", networkImageProvider));
        list.add(new MenuItem("empat", localImageProvider));
        squareMenuAdapter.setMenuItems(list);
        assertEquals(list.size(), squareMenuAdapter.getItemCount());
    }
}
