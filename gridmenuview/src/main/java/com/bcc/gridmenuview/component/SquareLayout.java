package com.bcc.gridmenuview.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class SquareLayout extends LinearLayout {
    public SquareLayout(Context context) {
        super(context);
    }

    public SquareLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
