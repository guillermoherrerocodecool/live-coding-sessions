package com.codecool.codewars.spiralpath;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

public class SpiralPathFinder {
    public int[] find(int[][] chart) {
        Cursor cursor = createCursor(chart);
        int limit = chart.length * chart.length;
        return Stream.generate(() -> next(cursor))
                .limit(limit)
                .mapToInt(coordinate -> chart[coordinate.x()][coordinate.y()])
                .toArray();
    }

    private Cursor createCursor(int[][] chart) {
        int size = chart.length;
        Queue<Coordinate> directions = createDirections();
        Coordinate preprocessedCoordinate = new Coordinate(-1, 0);
        Set<Coordinate> visited = new HashSet<>();
        return new Cursor(size, directions, visited, preprocessedCoordinate);
    }

    private Queue<Coordinate> createDirections() {
        Queue<Coordinate> directions = new LinkedList<>();
        directions.offer(new Coordinate(1, 0));
        directions.offer(new Coordinate(0, 1));
        directions.offer(new Coordinate(-1, 0));
        directions.offer(new Coordinate(0, -1));
        return directions;
    }

    private Coordinate next(Cursor cursor) {
        Queue<Coordinate> directions = cursor.getDirections();
        Coordinate next = calculateNext(cursor, directions);
        if (isInvalid(next, cursor)) {
            Coordinate direction = directions.poll();
            directions.offer(direction);
            next = calculateNext(cursor, directions);
        }
        cursor.setCurrent(next);
        cursor.getVisited().add(next);
        return next;
    }

    private Coordinate calculateNext(Cursor cursor, Queue<Coordinate> directions) {
        Coordinate current = cursor.getCurrent();
        Coordinate direction = directions.peek();
        return new Coordinate(
                current.x() + direction.x(),
                current.y() + direction.y()
        );
    }

    private boolean isInvalid(Coordinate next, Cursor cursor) {
        return isInvalidCoordinate(next, cursor) || isAlreadyVisited(next, cursor);
    }

    private boolean isInvalidCoordinate(Coordinate next, Cursor cursor) {
        return isInvalidCoordinate(next.x(), cursor.getSize()) || isInvalidCoordinate(next.y(), cursor.getSize());
    }

    private boolean isInvalidCoordinate(int coordinate, int limit) {
        return coordinate < 0 || coordinate >= limit;
    }

    private boolean isAlreadyVisited(Coordinate next, Cursor cursor) {
        return cursor.getVisited().contains(next);
    }
}
