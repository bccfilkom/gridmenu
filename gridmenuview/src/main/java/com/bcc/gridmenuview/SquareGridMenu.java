package com.bcc.gridmenuview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class SquareGridMenu extends FrameLayout {
    public SquareGridMenu(Context context) {
        super(context);
    }

    public SquareGridMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareGridMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
