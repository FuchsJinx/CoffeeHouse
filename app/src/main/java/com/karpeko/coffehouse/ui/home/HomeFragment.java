package com.karpeko.coffehouse.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.karpeko.coffehouse.R;
import com.karpeko.coffehouse.databinding.FragmentHomeBinding;
import com.karpeko.coffehouse.menu.CoffeeMenuItem;
import com.karpeko.coffehouse.menu.ExpandableAdapter;
import com.karpeko.coffehouse.menu.ExpandableItem;
import com.karpeko.coffehouse.menu.MenuAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        // Создаем данные для разделов и дочерних элементов
        List<ExpandableItem> expandableItems = new ArrayList<>();

        // Раздел "Кофе"
        List<CoffeeMenuItem> coffeeItems = new ArrayList<>();
        coffeeItems.add(new CoffeeMenuItem(R.drawable.capuchino, "Капучино", "150 руб.", "Эспрессо, горячее молоко, молочная пена"));
        coffeeItems.add(new CoffeeMenuItem(R.drawable.espresso, "Эспрессо", "120 руб.", "Эспрессо"));
        coffeeItems.add(new CoffeeMenuItem(R.drawable.latte, "Латте", "150 руб.", "Эспрессо, молоко, молочная пена"));
        expandableItems.add(new ExpandableItem("Кофе", coffeeItems));

        // Раздел "Выпечка"
        List<CoffeeMenuItem> bakery = new ArrayList<>();
        bakery.add(new CoffeeMenuItem(R.drawable.cruassan, "Круассан", "130 руб.", "Мука, вода, молоко, дрожжи, сахар, соль, масло, яйцо"));
        expandableItems.add(new ExpandableItem("Выпечка", bakery));

        // Раздел "Другие напитки"
                List<CoffeeMenuItem> otherDrinks = new ArrayList<>();
                otherDrinks.add(new CoffeeMenuItem(R.drawable.tea, "Чёрный чай", "100 руб.", "Черный чай"));
                expandableItems.add(new ExpandableItem("Другие напитки", otherDrinks));

        // Создаем и устанавливаем адаптер
        ExpandableAdapter expandableAdapter = new ExpandableAdapter(expandableItems);
        recyclerView.setAdapter(expandableAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}