package me.learning.tshirtmanagement.data;

import java.time.LocalDateTime;

public record Purchase(String id, double price, LocalDateTime timestamp, Customer customer, TShirt tShirt) {
}
