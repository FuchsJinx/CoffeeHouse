package com.karpeko.coffehouse.ui.dashboard.insideOrders.item;

public class Order {
    private String productName;
    private int quantity;
    private int price;
    private String imageUrl; // URL изображения товара

    public Order(String productName, int quantity, int price, String imageUrl) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}