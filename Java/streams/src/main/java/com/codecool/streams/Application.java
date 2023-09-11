package com.codecool.streams;

import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println("numbers = " + numbers);
        
        // beginning: .stream() // Stream.of
        // finite group of elements within the same collection
        numbers.stream();
        // finite group of elements
        Stream<Integer> digits = Stream.of(1, 2, 3, 4, 5); 
        //Stream.generate() - generate infinite elements
        
        // Intermediate operations
        // filter - potentially reduces the number of elements
        // map - transform one element into another
        // peek - access to one element, without altering it
        // sort - sorting all elements
        // limit - 
        
        
        // Terminal operations
        // end result
        // findFirst - finding one element
        // collect - group all elements that are remaining on the Stream
        // anyMatch, allMatch, noneMatch -
        // count
        // reduce
        // forEach
    }
    
    
}
