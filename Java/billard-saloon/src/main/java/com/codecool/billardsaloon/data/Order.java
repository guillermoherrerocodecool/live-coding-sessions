package com.codecool.billardsaloon.data;

import java.util.List;

public record Order(List<OrderElement> elements) {
}
