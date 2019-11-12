package main.kotlin

// From https://kotlinlang.org/docs/reference/sequences.html
val oddNumbers = generateSequence(1) { it + 2 } // `it` is the previous element

fun main() {
    println(oddNumbers.take(5).toList())
}
