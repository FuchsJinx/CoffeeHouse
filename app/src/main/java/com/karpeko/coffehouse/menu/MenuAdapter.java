package com.karpeko.coffehouse.menu;

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

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private List<CoffeeMenuItem> menuItems;

    public MenuAdapter(List<CoffeeMenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new MenuViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        CoffeeMenuItem menuItem = menuItems.get(position);
        holder.imageView.setImageResource(menuItem.getImageResID());
        holder.nameTextView.setText(menuItem.getName());
        holder.priceTextView.setText(menuItem.getPrice());
        holder.ingridientsTextView.setText(menuItem.getIngridients());
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nameTextView;
        TextView priceTextView;
        TextView ingridientsTextView;

        MenuViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.menu_icon);
            nameTextView = itemView.findViewById(R.id.menu_item_name);
            priceTextView = itemView.findViewById(R.id.menu_item_price);
            ingridientsTextView = itemView.findViewById(R.id.menu_item_ingridients);
        }
    }
}
