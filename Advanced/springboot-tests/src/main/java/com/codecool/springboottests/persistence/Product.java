package com.codecool.springboottests.persistence;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ElementCollection
    private Set<String> ingredients;
    private double price;
    private String uid;

    public Product() {
    }

    public Product(String name, Set<String> ingredients, double price, String uid) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.uid = uid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(ingredients, product.ingredients) && Objects.equals(uid, product.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ingredients, price, uid);
    }
}
