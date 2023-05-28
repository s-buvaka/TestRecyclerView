package com.example.myapplication;

public class Order {

    private String name;
    private String price;

    public Order(final String name, final String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(final String price) {
        this.price = price;
    }
}
