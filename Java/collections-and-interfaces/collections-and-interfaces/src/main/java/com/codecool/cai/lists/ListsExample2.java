package com.codecool.cai.lists;

import com.codecool.cai.Example;

import java.util.ArrayList;
import java.util.List;

public class ListsExample2 implements Example {

    @Override
    public void show() {
//        List<Integer> numbers = List.of(1, 2, 3,"3.5"); // OCD - Strongly Typed Variables
        List<Integer> immutableNumbers = List.of(1, 2, 3); // immutable
        System.out.println("numbers = " + immutableNumbers);
        // immutableNumbers.add(1); throws an exception
        System.out.println("numbers = " + immutableNumbers);
        // mutable or immutable
        List<Integer> mutableNumbers = new ArrayList<>(List.of(4, 5, 6));
        System.out.println("mutable numbers = " + mutableNumbers);
        mutableNumbers.add(1);
        System.out.println("mutable numbers = " + mutableNumbers);
    }
}
