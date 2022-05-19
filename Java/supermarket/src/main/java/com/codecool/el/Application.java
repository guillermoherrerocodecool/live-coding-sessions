package com.codecool.el;

import com.codecool.el.supermarket.logic.Catalogue;
import com.codecool.el.supermarket.logic.CheckOut;
import com.codecool.el.supermarket.logic.ShoppingCart;
import com.codecool.el.supermarket.data.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("banana", 0.15));
        items.add(new Item("apple", 0.30));

        Catalogue catalogue = new Catalogue(items);
        ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>());

        List<String> stuff = List.of("banana", "apple");
        for (String oneStuff : stuff) {
            Optional<Item> oItem = catalogue.take(oneStuff);
            Item item = oItem.get();
            shoppingCart.add(item);
        }
        CheckOut checkOut = new CheckOut();
        float price = checkOut.calculate(shoppingCart);
        System.out.println("Dear customer, pay me this much: " + price);
    }
}
