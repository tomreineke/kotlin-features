package main.kotlin

import java.util.Collections.*

fun main() {
    val strings = mutableListOf("Kotlin", "Java", "C++")

    println(
        max(strings, { a, b -> a.compareTo(b) })
    )
    println(
        max(strings) { a, b -> a.compareTo(b) }
    )
}