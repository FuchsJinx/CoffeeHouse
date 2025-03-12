package com.karpeko.coffehouse.ui.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.karpeko.coffehouse.R;
import com.karpeko.coffehouse.menu.ExpandableAdapter;
import com.karpeko.coffehouse.menu.ExpandableItem;
import com.karpeko.coffehouse.menu.MenuAdapter;

import java.util.List;

public class ExpandableActivitiesAdapter extends RecyclerView.Adapter<ExpandableActivitiesAdapter.GroupViewHolder>{
    private List<ExpandableActivitiesItem> data;

    public ExpandableActivitiesAdapter(List<ExpandableActivitiesItem> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ExpandableActivitiesAdapter.GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false);
        return new ExpandableActivitiesAdapter.GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpandableActivitiesAdapter.GroupViewHolder holder, int position) {
        ExpandableActivitiesItem item = data.get(position);
        holder.titleTextView.setText(item.getTitle());

        // Устанавливаем видимость дочернего RecyclerView в зависимости от состояния isExpanded
        if (item.isExpanded()) {
            holder.childLayout.setVisibility(View.VISIBLE);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
            ActivitiesAdapter menuAdapter = new ActivitiesAdapter(item.getChildren());
            holder.recyclerView.setAdapter(menuAdapter);
        } else {
            holder.childLayout.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(v -> {
            item.setExpanded(!item.isExpanded());
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // Теперь у нас только один ViewHolder - GroupViewHolder
    public static class GroupViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        RecyclerView recyclerView;
        LinearLayout childLayout;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.group_title);
            recyclerView = itemView.findViewById(R.id.child_recycler_view);
            childLayout = itemView.findViewById(R.id.child_layout);
        }
    }
}
