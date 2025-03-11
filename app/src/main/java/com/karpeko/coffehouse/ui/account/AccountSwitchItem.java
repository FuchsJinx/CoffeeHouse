package com.karpeko.coffehouse.ui.account;

public class AccountSwitchItem {
    private int iconResId;
    private String title;
    private boolean isChecked;

    public AccountSwitchItem(int iconResId, String title, boolean isChecked) {
        this.iconResId = iconResId;
        this.title = title;
        this.isChecked = isChecked;
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
