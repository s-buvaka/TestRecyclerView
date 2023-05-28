package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class OrderGenerator {

    public static List<Order> generateOrders() {
        ArrayList<Order> orders = new ArrayList<>();

        orders.add(new Order("Телефон", "900"));
        orders.add(new Order("Насос", "90"));
        orders.add(new Order("Зеркало", "91300"));
        orders.add(new Order("Ноутбук", "15423500"));
        orders.add(new Order("Кбу", "870"));
        orders.add(new Order("Монитор", "2300"));

        return orders;
    }

}
