package com.karpeko.coffehouse.ui.activities;

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
import com.karpeko.coffehouse.menu.ExpandableAdapter;
import com.karpeko.coffehouse.menu.ExpandableItem;

import java.util.ArrayList;
import java.util.List;

public class ActivitiesFragment extends Fragment {
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ActivitiesViewModel homeViewModel =
                new ViewModelProvider(this).get(ActivitiesViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        List<ExpandableActivitiesItem> expandableItems = new ArrayList<>();

        List<ActivitiesItem> activity1Items = new ArrayList<>();
        activity1Items.add(new ActivitiesItem(R.drawable.tea, "Открытие", "01.06.2020", "В этот день мы открылись"));
        expandableItems.add(new ExpandableActivitiesItem("Открытие", activity1Items));

        List<ActivitiesItem> activity2Items = new ArrayList<>();
        activity2Items.add(new ActivitiesItem(R.drawable.tea, "Создание приложения", "05.06.2025", "Мы запустили приложение упрощающие вам жизнь"));
        expandableItems.add(new ExpandableActivitiesItem("Запуск приложения", activity2Items));

        List<ActivitiesItem> activity3Items = new ArrayList<>();
        activity3Items.add(new ActivitiesItem(R.drawable.tea, "День рождения кафе", "01.06.2024", "Нашей кофейне уже 4 года!!!"));
        expandableItems.add(new ExpandableActivitiesItem("День рождения!", activity3Items));

        ExpandableActivitiesAdapter expandableAdapter = new ExpandableActivitiesAdapter(expandableItems);
        recyclerView.setAdapter(expandableAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
