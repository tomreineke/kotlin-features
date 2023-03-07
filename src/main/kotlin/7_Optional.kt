package main.kotlin

import java.lang.NullPointerException

/*
 * Here you can see the optional operator (?) and the Elvis operator (?:) in action.
 */

// Try to remove the Elvis operator and the following code in line 12
fun printOrThrow(text: String?) {
    //val char = text.get(0); throws compile error because text may be null here
    text?.let { println(it) } ?: throw NullPointerException()
    val char2 = text.get(0) // compiler knows text can not be null here
    println(char2)
}

fun main() {
    printOrThrow("random")
    printOrThrow(null)
}
