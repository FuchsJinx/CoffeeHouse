package com.karpeko.coffehouse.ui.account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.karpeko.coffehouse.R;

import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.AccountViewHolder> {
    private List<AccountItem> accountItems;

    public AccountAdapter(List<AccountItem> accountItems) {
        this.accountItems = accountItems;
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item, parent, false);
        return new AccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder holder, int position) {
        AccountItem item = accountItems.get(position);
        holder.iconImageView.setImageResource(item.getIconResId());
        holder.titleTextView.setText(item.getTitle());

        // Обработка нажатия на элемент
        holder.itemView.setOnClickListener(v -> {
            // Здесь вы можете добавить логику для каждого элемента
            Toast.makeText(holder.itemView.getContext(), "Нажата: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            // Например, открыть новый фрагмент или активити
        });
    }

    @Override
    public int getItemCount() {
        return accountItems.size();
    }

    public static class AccountViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImageView;
        TextView titleTextView;

        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImageView = itemView.findViewById(R.id.item_icon);
            titleTextView = itemView.findViewById(R.id.item_title);
        }
    }
}

