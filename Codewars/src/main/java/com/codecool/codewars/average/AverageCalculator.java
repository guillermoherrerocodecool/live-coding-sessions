package com.codecool.codewars.average;

public class AverageCalculator {
    public double calculate(int[] numbers) {
        if(numbers.length == 0){
            return 0;
        }
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }
}
