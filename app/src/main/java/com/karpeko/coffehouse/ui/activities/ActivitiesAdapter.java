package com.karpeko.coffehouse.ui.activities;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.karpeko.coffehouse.R;

import java.util.List;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder> {
    private List<ActivitiesItem> activitiesItems;

    public ActivitiesAdapter(List<ActivitiesItem> activitiesItems) { this.activitiesItems = activitiesItems; }

    @NonNull
    @Override
    public ActivitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activities_item, parent, false);
        return new ActivitiesViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull ActivitiesViewHolder holder, int position) {
        ActivitiesItem activitiesItem = activitiesItems.get(position);
        holder.imageView.setImageResource(activitiesItem.getImageResID());
        holder.activitiesNameTextView.setText(activitiesItem.getNameActivities());
        holder.dateTextView.setText(activitiesItem.getDate());
        holder.descriptionTextView.setText(activitiesItem.getDescription());
    }

    @Override
    public int getItemCount() {return activitiesItems.size(); }

    static class ActivitiesViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView activitiesNameTextView;
        TextView dateTextView;
        TextView descriptionTextView;

        ActivitiesViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.activities_item_icon);
            activitiesNameTextView = itemView.findViewById(R.id.activities_item_name);
            dateTextView = itemView.findViewById(R.id.activities_item_date);
            descriptionTextView = itemView.findViewById(R.id.activities_item_description);
        }
    }
}
