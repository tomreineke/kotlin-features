package main.kotlin

import java.lang.NullPointerException

fun printOrThrow(text: String?) {
    //val char = text.get(0); throws compile error because text may be null here
    text?.let{println(it)} ?: throw NullPointerException()
    val char2 = text.get(0); // compiler knows text can not be null here
    println(char2)
}

fun main() {
    printOrThrow("apt")
    printOrThrow(null)
}