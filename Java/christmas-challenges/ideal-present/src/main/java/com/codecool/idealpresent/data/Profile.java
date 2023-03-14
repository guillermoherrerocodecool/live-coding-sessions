package com.codecool.idealpresent.data;

import java.util.Set;

public record Profile(
        String name, 
        Set<String> actions, 
        int karma, 
        Set<String> categories, 
        Set<String> presents) {
}
