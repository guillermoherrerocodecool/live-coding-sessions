package me.learning.tshirtmanagement.logic;

import me.learning.tshirtmanagement.data.Purchase;

import java.time.LocalDateTime;
import java.util.Set;

public class RevenueService {
    public double calculateRevenueWithinThisMonth(LocalDateTime reference, Set<Purchase> purchases) {
        LocalDateTime firstDayOfMonth = LocalDateTime.of(reference.getYear(), reference.getMonth(), 1, 0, 0, 0);
        LocalDateTime beginningOfMonth = firstDayOfMonth.minusDays(1);
        LocalDateTime endOfMonth = firstDayOfMonth.plusMonths(1);
        return purchases.stream()
                .filter(purchase -> purchase.timestamp().isAfter(beginningOfMonth))
                .filter(purchase -> purchase.timestamp().isBefore(endOfMonth))
                .mapToDouble(Purchase::price)
                .sum();
    }
}
