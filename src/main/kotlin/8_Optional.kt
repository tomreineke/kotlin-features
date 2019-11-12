package main.kotlin

import java.lang.NullPointerException

fun printOrThrow(text: String?) {
    //val char = text.get(0);
    text?.let{println(it)} ?: throw NullPointerException()
    val char2 = text.get(0);
    println(char2)
}

fun main() {
    printOrThrow("apt")
    printOrThrow(null)
}