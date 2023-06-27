package com.codecool.katas

fun findMiddleCharacter(word: String) =
    word.substring(findStartIndex(word), findEndIndex(word))


private fun findStartIndex(word: String) = (word.length - 1) / 2

private fun findEndIndex(word: String) = (word.length / 2) + 1