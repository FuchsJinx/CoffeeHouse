package com.karpeko.coffehouse.ui.activities;

public class ActivitiesItem {
    private int imageResID;
    private String name;
    private String date;
    private String description;

    public ActivitiesItem(int imageResID, String name, String date, String description) {
        this.imageResID = imageResID;
        this.name = name;
        this.date = date;
        this.description = description;
    }

    public int getImageResID() { return imageResID;}
    public String getNameActivities() { return name; }
    public  String getDate() { return date; }
    public String getDescription() { return description; }
}
