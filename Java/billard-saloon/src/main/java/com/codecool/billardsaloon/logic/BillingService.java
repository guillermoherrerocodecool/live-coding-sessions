package com.codecool.billardsaloon.logic;

import com.codecool.billardsaloon.data.Order;
import com.codecool.billardsaloon.data.OrderElement;
import com.codecool.billardsaloon.data.Receipt;
import com.codecool.billardsaloon.data.TableType;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BillingService {
    private final Map<TableType, Double> prices;

    public BillingService(Map<TableType, Double> prices) {
        this.prices = prices;
    }

    public double calculate(Receipt receipt) {
        String hi = "Hi there";
        
        Stream.of(hi.split(""))
        return receipt.getOrders().stream()
                .map(Order::elements)
                .flatMap(List::stream)
                .mapToDouble(OrderElement::price)
                .sum();
    }
}
