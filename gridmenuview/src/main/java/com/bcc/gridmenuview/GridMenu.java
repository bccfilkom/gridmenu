package com.bcc.gridmenuview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bcc.gridmenuview.adapter.GridMenuAdapter;
import com.bcc.gridmenuview.event.OnItemClickListener;
import com.bcc.gridmenuview.model.MenuItem;

import java.util.List;

public class GridMenu extends FrameLayout {
    private static final int DEFAULT_SPAN_COUNT = 3;

    private GridMenuAdapter adapter = new GridMenuAdapter();
    private int spanCount;

    public GridMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupAttribute(attrs);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), spanCount));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new CenterItemDecoration());
        addView(recyclerView);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        adapter.setMenuItems(menuItems);
    }

    /**
     * setupAttribute reads XML spanCount attribute and store it to spanCount instance variable
     */
    private void setupAttribute(@Nullable AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme()
                .obtainStyledAttributes(attrs, R.styleable.GridMenu, 0, 0);

        spanCount = typedArray.getInt(R.styleable.GridMenu_spanCount, DEFAULT_SPAN_COUNT);

        typedArray.recycle();
    }

    public void setOnClickListener(OnItemClickListener listener) {
        adapter.setOnClickListener(listener);
    }

    private class CenterItemDecoration extends RecyclerView.ItemDecoration {

        private void measureItemView(View itemView, ViewGroup parent) {
            if (itemView.getLayoutParams() == null) {
                itemView.setLayoutParams(
                        new ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                );
            }

            int widthSpec = View.MeasureSpec.makeMeasureSpec(
                    parent.getMeasuredWidth(),
                    MeasureSpec.EXACTLY
            );
            int heightSpec = View.MeasureSpec.makeMeasureSpec(
                    parent.getMeasuredHeight(),
                    MeasureSpec.UNSPECIFIED
            );
            int itemViewWidth = ViewGroup.getChildMeasureSpec(
                    widthSpec,
                    parent.getPaddingLeft() + parent.getPaddingRight(),
                    itemView.getLayoutParams().width
            );
            int itemViewHeight = ViewGroup.getChildMeasureSpec(
                    heightSpec,
                    parent.getPaddingTop() + parent.getPaddingBottom(),
                    itemView.getLayoutParams().height
            );
            itemView.measure(itemViewWidth, itemViewHeight);
            itemView.layout(0, 0, itemView.getMeasuredWidth(), itemView.getMeasuredHeight());
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            measureItemView(view, parent);

            int viewWidth = view.getMeasuredWidth();
            if (spanCount * viewWidth < parent.getMeasuredWidth()) {
                int emptySpacePx = parent.getMeasuredWidth() - spanCount * viewWidth;
                outRect.left = outRect.right = emptySpacePx / (2 * spanCount);
            }
        }
    }
}
