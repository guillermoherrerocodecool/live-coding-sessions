package com.codecool.el.supermarket.logic;

import com.codecool.el.supermarket.data.Item;

import java.util.List;

public class CheckOut {
    public float calculate(ShoppingCart shoppingCart) {
        List<Item> items = shoppingCart.getItems();
        float sum = 0;
        for (Item item : items) {
            double price = item.getPrice();
            sum += price;
        }
        return sum;
    }
}
