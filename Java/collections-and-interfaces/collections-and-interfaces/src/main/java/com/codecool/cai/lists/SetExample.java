package com.codecool.cai.lists;

import com.codecool.cai.Example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExample implements Example {
    @Override
    public void show() {
        List<String> mondayAttendance = new ArrayList<>();
        mondayAttendance.add("Manuela");
        mondayAttendance.add("Bernie");
        mondayAttendance.add("Chen");
        System.out.println("Monday attendance = " + mondayAttendance);
        List<String> tuesdayAttendance = new ArrayList<>();
        tuesdayAttendance.add("Lukas");
        tuesdayAttendance.add("Bernie");
        tuesdayAttendance.add("Albert");
        tuesdayAttendance.add("Amy");
        System.out.println("Tuesday attendance = " + tuesdayAttendance);
        List<String> generalAttendance = new ArrayList<>();
        generalAttendance.addAll(mondayAttendance);
        System.out.println("generalAttendance after Monday= " + generalAttendance);
        generalAttendance.addAll(tuesdayAttendance);
        System.out.println("generalAttendance after Tuesday= " + generalAttendance);
        Set<String> uniqueNames = new HashSet<>(generalAttendance);
        System.out.println("uniqueNames = " + uniqueNames);
    }
}
