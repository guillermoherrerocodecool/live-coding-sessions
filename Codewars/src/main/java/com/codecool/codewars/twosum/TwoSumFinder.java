package com.codecool.codewars.twosum;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class TwoSumFinder {
    public int[] findTwoSum(int[] numbers, int target) {
        return IntStream.range(0, numbers.length)
                .mapToObj(toListOfPairs(numbers))
                .flatMap(List::stream)
                .filter(pair-> areIndexesDifferent(pair))
                .filter(pair -> matches(pair, numbers, target))
                .findFirst()
                .map(toArray())
                .orElseThrow();
    }

    private IntFunction<List<Pair>> toListOfPairs(int[] numbers) {
        return i1 -> IntStream.range(0, numbers.length)
                .mapToObj(i2 -> new Pair(i1, i2))
                .toList();
    }

    private boolean areIndexesDifferent(Pair pair) {
        return pair.first() != pair.second();
    }

    private boolean matches(Pair pair, int[] numbers, int target) {
        int number1 = numbers[pair.first()];
        int number2 = numbers[pair.second()];
        return number1 + number2 == target;
    }

    private Function<Pair, int[]> toArray() {
        return pair -> new int[]{pair.first(), pair.second()};
    }

}
