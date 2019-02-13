package com.hosik.product;

public class Product {
    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return "name: " + getName() + "\n" +
                "price: " + getPrice() + "\n" +
                "quantity: " + getQuantity() + "\n";
    }
}
