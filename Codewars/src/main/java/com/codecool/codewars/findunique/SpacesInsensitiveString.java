package com.codecool.codewars.findunique;

import java.util.Objects;

public record SpacesInsensitiveString(String value) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpacesInsensitiveString that = (SpacesInsensitiveString) o;
        String thatWithoutSpaces = that.value.replaceAll("\\s", "");
        String thisWithoutSpaces = value.replaceAll("\\s", "");
        return Objects.equals(thisWithoutSpaces, thatWithoutSpaces);
    }
}
