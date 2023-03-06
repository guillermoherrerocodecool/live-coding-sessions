package com.codecool.karmatm.logic.reader;

public interface DataTransformer<E> {
    E transform(String line);
}
