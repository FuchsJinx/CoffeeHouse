package com.karpeko.coffehouse.ui.activities;

import com.karpeko.coffehouse.menu.CoffeeMenuItem;

import java.util.List;

public class ExpandableActivitiesItem {
    private String title; // Заголовок раздела
    private List<ActivitiesItem> children; // Список дочерних элементов (CoffeeMenuItem)
    private boolean isExpanded; // Флаг, развернут ли раздел

    public ExpandableActivitiesItem(String title, List<ActivitiesItem> children) {
        this.title = title;
        this.children = children;
        this.isExpanded = false; // По умолчанию раздел свернут
    }

    // Геттеры и сеттеры
    public String getTitle() {
        return title;
    }

    public List<ActivitiesItem> getChildren() {
        return children;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
