package main.kotlin

/*
 * Kotlin allows object-functional programming.
 */

// Adapted from https://kotlinlang.org/docs/reference/lambdas.html
class HTML(var name : String) {
    fun body() {
        println("body output from $name")
    }
}

fun HTML.mySpecialMethod(input : String) {
    name = input
    body()
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML("greatHTML")  // create the receiver object
    html.init()        // pass the receiver object to the lambda
    return html
}

fun main() {
    html {       // lambda with receiver begins here
        body()   // calling a method on the receiver object
    }

    html {
        mySpecialMethod("new name")
    }
}
