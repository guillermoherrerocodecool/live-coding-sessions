package me.learning.tshirtmanagement.logic;

import me.learning.tshirtmanagement.data.Color;
import me.learning.tshirtmanagement.data.Purchase;
import me.learning.tshirtmanagement.data.Size;

import java.util.Set;

public class TShirtService {
    public long calculateNumberOfTShirtsByColorAndSize(Set<Purchase> purchases, Color color, Size size) {
        return purchases.stream()
                .filter(purchase -> purchase.tShirt().color().equals(color))
                .filter(purchase -> purchase.tShirt().size().equals(size))
                .count();
    }
}
