package com.codecool.el.supermarket.logic;

import com.codecool.el.supermarket.data.Item;

import java.util.List;
import java.util.Optional;

public class Catalogue {
    private final List<Item> items;

    public Catalogue(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }

    public Optional<Item> take(String target) {
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            if (item.getName().equals(target)) {
                items.remove(index);
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }
}
