package com.karpeko.coffehouse.menu;

import java.util.List;

public class ExpandableItem {
    private String title; // Заголовок раздела
    private List<CoffeeMenuItem> children; // Список дочерних элементов (CoffeeMenuItem)
    private boolean isExpanded; // Флаг, развернут ли раздел

    public ExpandableItem(String title, List<CoffeeMenuItem> children) {
        this.title = title;
        this.children = children;
        this.isExpanded = false; // По умолчанию раздел свернут
    }

    // Геттеры и сеттеры
    public String getTitle() {
        return title;
    }

    public List<CoffeeMenuItem> getChildren() {
        return children;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
