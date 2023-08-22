package com.codecool.practice

fun main() {
    println("Hello world")

    var number = createNumber()
    var names = listOf("Fleischi", "Dea", "Phillip")
    

    val food1 = Food("Hummus", null)
    println(food1)
    food1.price = number
    println(food1)
}

fun createNumber() = listOf(1, 2, 3, 4)
    .map { it + 1 }
    .first { it > 2 }

