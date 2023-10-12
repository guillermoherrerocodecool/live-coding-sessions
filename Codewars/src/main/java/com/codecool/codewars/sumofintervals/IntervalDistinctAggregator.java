package com.codecool.codewars.sumofintervals;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntervalDistinctAggregator {
    public int aggregate(int[][] intervals) {
        Queue<Interval> sorted = getSorted(intervals);
        int sum = 0;
        while (!sorted.isEmpty()) {
            Interval current = sorted.poll();
            int length = current.right() - current.left();
            if (!sorted.isEmpty()) {
                Interval next = sorted.peek();
                if (current.right() > next.right()) {
                    length += current.right() - next.right();
                }
                if (current.right() > next.left()) {
                    length -= current.right() - next.left();
                }
            }
            sum += length;
        }
        return sum;
    }

    private Queue<Interval> getSorted(int[][] intervals) {
        return Stream.of(intervals)
                .map(interval -> new Interval(interval[0], interval[1]))
                .sorted(Comparator.comparingInt(Interval::left))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
