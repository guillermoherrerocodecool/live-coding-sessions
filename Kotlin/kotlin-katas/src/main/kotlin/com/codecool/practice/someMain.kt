package com.codecool.practice

fun main() {
    val names = mutableListOf("Bernie", "Alen", "Adrian", "Chris")
    println(names)
    val people = names.mapIndexed { index, it -> Person(it, it.length, index) }
    println(people)
    val person = people[1]
    println(person)
    person.money = 4
    println(person.money)
}