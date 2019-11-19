package main.kotlin

import java.util.Collections.*

/*
 * Here you see how a trailing lambda is usually written in Kotlin. IntelliJ suggests moving the lambda argument
 * out of the parenthesis.
 * Trailing lambdas
 *      - only work, when they are the last argument of a function
 *      - make Kotlin code so good for DSL
 */

fun main() {
    val strings = mutableListOf("Kotlin", "Java", "C++")

    println(
        max(strings, { a, b -> a.compareTo(b) })
    )
    println(
        max(strings) { a, b -> a.compareTo(b) }
    )
}
