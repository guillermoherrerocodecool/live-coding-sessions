package com.codecool.cai.lists;

import com.codecool.cai.Example;

import java.util.Collections;
import java.util.Stack;

public class StackExample implements Example {
    @Override
    public void show() {
        Stack<String> backpack = new Stack<>();
        backpack.add("First Aid Kit");
        backpack.add("Cooking Stuff");
        backpack.add("Sleeping pad");
        backpack.add("Sleeping bag");
        // LIFO // Last In First Out
//        Collections.reverse(backpack);
        String item = backpack.pop();
        System.out.println("item = " + item);
    }
}
