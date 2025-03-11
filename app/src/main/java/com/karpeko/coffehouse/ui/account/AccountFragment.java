package com.karpeko.coffehouse.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.karpeko.coffehouse.LoginActivity;
import com.karpeko.coffehouse.R;
import com.karpeko.coffehouse.databinding.FragmentAccountBinding;

import java.util.ArrayList;
import java.util.List;

public class AccountFragment extends Fragment {
    private FragmentAccountBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AccountViewModel homeViewModel =
                new ViewModelProvider(this).get(AccountViewModel.class);

        binding = FragmentAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Находим RecyclerView
        RecyclerView recyclerView = root.findViewById(R.id.account_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        // Создаем список элементов
        List<AccountItem> accountItems = new ArrayList<>();
        accountItems.add(new AccountItem(R.drawable.ic_settings, "Настройки"));
        accountItems.add(new AccountItem(R.drawable.ic_history, "История заказов"));
        accountItems.add(new AccountItem(R.drawable.ic_favorite, "Избранное"));
        accountItems.add(new AccountItem(R.drawable.ic_library, "Библиотека"));

        // Создаем и устанавливаем адаптер
        AccountAdapter accountAdapter = new AccountAdapter(accountItems);
        recyclerView.setAdapter(accountAdapter);

        // Находим кнопку входа
        Button loginButton = root.findViewById(R.id.login_button);
        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
