package com.karpeko.coffehouse.menu;

public class CoffeeMenuItem {

    private int imageResID;
    private String name;
    private String price;
    private String ingridients;

    public CoffeeMenuItem(int imageResID, String name, String price, String ingridients) {
        this.imageResID = imageResID;
        this.name = name;
        this.price = price;
        this.ingridients = ingridients;
    }

    public int getImageResID() {
        return imageResID;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getIngridients() {
        return "Состав: " + ingridients;
    }
}
