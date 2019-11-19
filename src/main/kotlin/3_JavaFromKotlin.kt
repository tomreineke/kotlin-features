package main.kotlin

import java.util.ArrayList


/*
 * Here you see how you can create a Kotlin class inheriting from a Java class. It's seamless.
 */

class MyList<T> : ArrayList<T>() {
    fun myNewMethod() {
        val it = this.iterator()
        while(it.hasNext()) {
            println("KK: " + it.next())
        }
    }
}

fun main() {
    val list = MyList<String>()
    list.addAll(listOf("a", "b", "c"))
    list.myNewMethod()
}
