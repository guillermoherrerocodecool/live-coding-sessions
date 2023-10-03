package com.codecool.codewars.spiralpath;

import java.util.Queue;
import java.util.Set;

public class Cursor {
    private final int size;
    private final Queue<Coordinate> directions;
    private final Set<Coordinate> visited;
    private Coordinate current;

    public Cursor(int size, Queue<Coordinate> directions, Set<Coordinate> visited, Coordinate current) {
        this.size = size;
        this.directions = directions;
        this.visited = visited;
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public Queue<Coordinate> getDirections() {
        return directions;
    }

    public Set<Coordinate> getVisited() {
        return visited;
    }

    public Coordinate getCurrent() {
        return current;
    }

    public void setCurrent(Coordinate current) {
        this.current = current;
    }
}
