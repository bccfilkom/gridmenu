package com.bcc.gridmenuview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bcc.gridmenuview.R;
import com.bcc.gridmenuview.event.OnItemClickListener;
import com.bcc.gridmenuview.model.MenuItem;
import com.bcc.gridmenuview.task.ImageUrlAsyncTask;

import java.util.List;
import java.util.concurrent.ExecutionException;

import de.hdodenhof.circleimageview.CircleImageView;

public class GridMenuAdapter extends RecyclerView.Adapter<GridMenuAdapter.ViewHolder> {
    private List<MenuItem> menuItems;
    private OnItemClickListener gridMenuOnClickListener;

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        notifyDataSetChanged();
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.gridMenuOnClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_menu_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.title.setText(menuItems.get(position).getTitle());
        if (menuItems.get(position).getUrl() == null) {
            holder.image.setImageDrawable(menuItems.get(position).getImage());
        } else {
            ImageUrlAsyncTask imageAsync = (ImageUrlAsyncTask) new ImageUrlAsyncTask()
                    .execute(menuItems.get(position).getUrl(), holder.image.getContext());
            try {
                holder.image.setImageDrawable(imageAsync.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        holder.imageOverlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gridMenuOnClickListener != null) {
                    gridMenuOnClickListener.onClick(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private CircleImageView image;
        private ImageView imageOverlay;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tv_title);
            this.image = itemView.findViewById(R.id.civ_image);
            this.imageOverlay = itemView.findViewById(R.id.iv_image_overlay);
        }
    }
}
