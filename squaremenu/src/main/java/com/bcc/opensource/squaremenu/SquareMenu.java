package com.bcc.opensource.squaremenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SquareMenu extends View {
    private SquareMenuAdapter adapter = new SquareMenuAdapter();

    public SquareMenu(@NonNull Context context) {
        super(context);
    }

    public SquareMenu(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareMenu(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
