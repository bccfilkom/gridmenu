package com.bcc.opensource.squaremenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SquareMenu extends FrameLayout {
    private static final int DEFAULT_SPAN_COUNT = 3;

    private SquareMenuAdapter adapter = new SquareMenuAdapter();
    private int spanCount;

    public SquareMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupAttribute(attrs);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), spanCount));
        recyclerView.setAdapter(adapter);
        addView(recyclerView);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        adapter.setMenuItems(menuItems);
    }

    private void setupAttribute(@Nullable AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme()
                .obtainStyledAttributes(attrs, R.styleable.SquareMenu, 0, 0);

        spanCount = typedArray.getInt(R.styleable.SquareMenu_spanCount, DEFAULT_SPAN_COUNT);

        typedArray.recycle();
    }
}
