package me.learning.tshirtmanagement.logic;

import me.learning.tshirtmanagement.data.Customer;
import me.learning.tshirtmanagement.data.Purchase;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CustomerService {
    public Optional<Customer> findCustomerWithMostAmountOfPurchases(Set<Purchase> purchases) {
        return purchases.stream()
                .collect(groupingBy(Purchase::customer, counting()))
                .entrySet().stream()
                .max(comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey);
    }
}
