package main.kotlin

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty

inline fun <reified T> observe(defaultValue: T): ReadWriteProperty<Any?, T> {
    return Delegates.observable(defaultValue) {
            property, oldValue, newValue -> println("$property changed from $oldValue to $newValue")
    }
}

class Foo {
    var list: List<String> = listOf("a")
    var foo: Int by observe(0)
    var bar: String by observe("initialValue")
}

class User(map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

fun main() {
    println("###################### Foo ############################")
    val f = Foo()
    val oldList = f.list
    f.list += "b" // creates completely new list of ("a", "b"). Doesn't change the previously referenced list
    println(f.list)
    println(oldList)
    f.foo++
    f.bar = "updateValue"

    println("###################### User ############################")
    val user = User(mapOf(
        "name" to "John Doe",
        "age"  to 25
    ))
    println(user.name) // Prints "John Doe"
    println(user.age)
}
