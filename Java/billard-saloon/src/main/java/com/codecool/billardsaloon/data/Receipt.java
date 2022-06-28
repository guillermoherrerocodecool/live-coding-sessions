package com.codecool.billardsaloon.data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Receipt {
    private final Table table;
    private final List<Order> orders;
    private final LocalDateTime reservationTime;
    private Optional<LocalDateTime> endTime;

    public Receipt(Table table, List<Order> orders, LocalDateTime reservationTime) {
        this.table = table;
        this.orders = orders;
        this.reservationTime = reservationTime;
    }

    public Table getTable() {
        return table;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public Optional<LocalDateTime> getEndTime() {
        return endTime;
    }

    public void setEndTime(Optional<LocalDateTime> endTime) {
        this.endTime = endTime;
    }
}
