package com.codecool.cai.lists;

import com.codecool.cai.Example;
import com.codecool.cai.data.Person;

import java.util.HashSet;
import java.util.Set;

public class SetExample2 implements Example {
    @Override
    public void show() {
        Set<Person> people = new HashSet<>();
        people.add(new Person("Bernie"));
        people.add(new Person("Julia"));
        people.add(new Person("Amy"));
        people.add(new Person("Amy"));
        System.out.println("people = " + people);
    }
}
