package main.kotlin

class Foo {
    var foo: List<String> = listOf("a")
}

fun main() {
    val f = Foo()
    val oldList = f.foo
    f.foo += "b" // creates completely new list of ("a", "b"). Doesn't change the previously referenced list
    println(f.foo)
    println(oldList)
}
