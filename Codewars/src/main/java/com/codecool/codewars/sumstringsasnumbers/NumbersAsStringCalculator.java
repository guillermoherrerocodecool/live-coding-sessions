package com.codecool.codewars.sumstringsasnumbers;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;

public class NumbersAsStringCalculator {
    public String sum(String number1, String number2) {
        if (number1.isEmpty() && number2.isEmpty()) {
            return "";
        }
        Stack<String> digits1 = toDigits(number1);
        Stack<String> digits2 = toDigits(number2);
        Stack<String> sum = sum(digits1, digits2);
        return toNumber(sum);
    }

    private Stack<String> toDigits(String number) {
        if (number.equals("0") || number.isEmpty()) {
            return Arrays.stream("0".split(""))
                    .collect(toCollection(Stack::new));
        }
        return Arrays.stream(number.split(""))
                .dropWhile(digit -> digit.equals("0"))
                .collect(toCollection(Stack::new));
    }

    private Stack<String> sum(Stack<String> digits1, Stack<String> digits2) {
        Stack<String> result = new Stack<>();
        int shift = 0;
        while (!digits1.isEmpty() || !digits2.isEmpty()) {
            int number1 = popAsIntOrZero(digits1);
            int number2 = popAsIntOrZero(digits2);
            int sum = number1 + number2 + shift;
            shift = 0;
            if (sum > 9) {
                shift = 1;
                sum -= 10;
            }
            String digit = String.valueOf(sum);
            result.push(digit);
        }
        if (shift > 0) {
            result.push("1");
        }
        return result;
    }

    private int popAsIntOrZero(Stack<String> digits) {
        return digits.isEmpty() ? 0 : Integer.parseInt(digits.pop());
    }

    private String toNumber(Stack<String> digits) {
        return Stream.generate(digits::pop)
                .limit(digits.size())
                .collect(joining());
    }
}
