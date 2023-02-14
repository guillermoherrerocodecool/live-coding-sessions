package com.codecool.cai.lists;

import com.codecool.cai.Example;

import java.util.LinkedList;
import java.util.List;

public class ListsExample implements Example {
    public void show() {        
        List<Integer> numbers = new LinkedList<>();
        System.out.println("numbers = " + numbers);
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);
        numbers.add(10);
        System.out.println("numbers = " + numbers);
        numbers.remove(new Integer(10));
        System.out.println("numbers = " + numbers);
        int size = numbers.size();
        System.out.println("size = " + size);
    }
}
