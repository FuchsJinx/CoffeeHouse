package com.karpeko.coffehouse.ui.account;

public class AccountItem {
    private int iconResId;
    private String title;

    public AccountItem(int iconResId, String title) {
        this.iconResId = iconResId;
        this.title = title;
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getTitle() {
        return title;
    }
}
