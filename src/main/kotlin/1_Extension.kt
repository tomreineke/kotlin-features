package main.kotlin

fun List<String>.myMax() : String {
    var biggest = ""
    this.forEach {
        if (it.length > biggest.length) {
            biggest = it
        }
    }
    return biggest
}

fun main() {
    val strings = mutableListOf("Kotlin", "Java", "C++")
    println(strings.myMax())
}
