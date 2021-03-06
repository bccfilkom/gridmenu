package com.bcc.gridmenuview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bcc.gridmenuview.adapter.GridMenuAdapter;
import com.bcc.gridmenuview.component.Circle;
import com.bcc.gridmenuview.component.Shape;
import com.bcc.gridmenuview.component.Square;
import com.bcc.gridmenuview.event.OnItemClickListener;
import com.bcc.gridmenuview.model.MenuItem;
import com.bcc.gridmenuview.utils.ShapeElement;
import com.christophesmet.android.views.maskableframelayout.MaskableFrameLayout;

import java.util.List;

public class GridMenu extends FrameLayout {
    private static final int DEFAULT_SPAN_COUNT = 3;
    private static final int DEFAULT_SHAPE_ITEM = 0;

    private GridMenuAdapter adapter = new GridMenuAdapter();

    private ImageView menuItemOverlay;
    private MaskableFrameLayout maskableFrameLayout;

    private int spanCount;
    private int shapeItem;

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
        shapeItem = typedArray.getInt(R.styleable.GridMenu_shapeItem, DEFAULT_SHAPE_ITEM);

        typedArray.recycle();
    }

    public void setOnClickListener(OnItemClickListener listener) {
        adapter.setOnClickListener(listener);
    }

    private void setMenuItemShape() throws Exception {
        ShapeElement shapeLabel = ShapeElement.values()[shapeItem];
        Shape shape;
        switch (shapeLabel) {
            case SQUARE:
                shape = new Square(maskableFrameLayout, menuItemOverlay);
                break;
            case CIRCLE:
                shape = new Circle(maskableFrameLayout, menuItemOverlay);
                break;
            default:
                throw new Exception("Failed to set shape attributes with undefined shape");
        }
        shape.maskShape();
        shape.shapeOverlay();
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

            maskableFrameLayout = view.findViewById(R.id.frm_mask);
            menuItemOverlay = view.findViewById(R.id.iv_image_overlay);

            try {
                setMenuItemShape();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
