package com.bcc.gridmenuview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GridMenuAdapter extends RecyclerView.Adapter<GridMenuAdapter.ViewHolder> {
    private List<MenuItem> menuItems;
    private GridMenuOnClickListener gridMenuOnClickListener;

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        notifyDataSetChanged();
    }

    public void setOnClickListener(GridMenuOnClickListener listener){
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
        holder.image.setImageDrawable(menuItems.get(position).getImage());
        holder.card.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                gridMenuOnClickListener.ontClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout card;
        private TextView title;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.card = itemView.findViewById(R.id.ll_card);
            this.title = itemView.findViewById(R.id.tv_title);
            this.image = itemView.findViewById(R.id.iv_image);
        }
    }
}
