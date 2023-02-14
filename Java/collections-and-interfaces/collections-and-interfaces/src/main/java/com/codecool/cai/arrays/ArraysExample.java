package com.codecool.cai.arrays;

import com.codecool.cai.Example;

import java.util.Arrays;

public class ArraysExample implements Example {
    public void show() {
        Integer[] numbers = new Integer[3];
        System.out.println("numbers = " + Arrays.toString(numbers));
        numbers[1] = 7;
        addNumber(numbers, 2);
        addNumber(numbers, 5);
        addNumber(numbers, 10);
        System.out.println("numbers = " + Arrays.toString(numbers));


    }

    private void addNumber(Integer[] numbers, Integer number) {
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == null) {
                numbers[index] = number;
                break;
            }
        }
    }
}
