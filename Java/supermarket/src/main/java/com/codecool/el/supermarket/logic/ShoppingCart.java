package com.codecool.el.supermarket.logic;

import com.codecool.el.supermarket.data.Item;

import java.util.List;

public class ShoppingCart {
    private final List<Item> items;

    public ShoppingCart(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(String target) {
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            if (item.getName().equals(target)) {
                items.remove(index);
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
