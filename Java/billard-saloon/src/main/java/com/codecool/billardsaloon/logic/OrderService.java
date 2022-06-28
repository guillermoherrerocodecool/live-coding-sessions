package com.codecool.billardsaloon.logic;

import com.codecool.billardsaloon.data.Order;
import com.codecool.billardsaloon.data.OrderElement;
import com.codecool.billardsaloon.data.Receipt;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class OrderService {
    private final Set<OrderElement> available;

    public OrderService(Set<OrderElement> available) {
        this.available = available;
    }

    public void take(Receipt receipt, List<String> orderElementNames) {
        List<OrderElement> orderElements = find(orderElementNames);
        Order order = new Order(orderElements);
        receipt.getOrders().add(order);
    }

    private List<OrderElement> find(List<String> orderElementNames) {
        return orderElementNames.stream()
                .map(this::find)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toList());
    }

    private Optional<OrderElement> find(String name) {
        return available.stream()
                .filter(available -> available.name().equalsIgnoreCase(name))
                .findFirst();
    }
}
