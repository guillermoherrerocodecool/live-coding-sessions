package com.codecool.cats.service;

import com.codecool.cats.data.Cat;

import java.util.List;
import java.util.Optional;

public class CatStorage {
    private final List<Cat> cats;

    public CatStorage(List<Cat> cats) {
        this.cats = cats;
    }

    public void create(Cat cat) {
        cats.add(cat);
    }

    public List<Cat> readAll() {
        return cats;
    }

    public Optional<Cat> readOneByName(String name) {
        return cats.stream()
                .filter(cat -> cat.name().equals(name))
                .findFirst();
    }

    public Cat update(Cat cat) {
        delete(cat.name());
        cats.add(cat);
        return cat;
    }

    public void delete(String name) {
        cats.removeIf(existing -> existing.name().equals(name));
    }
}
