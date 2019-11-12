package main.kotlin

abstract class AbstractDetail

class DetailA(var name : String) : AbstractDetail() {
    fun printDetail() {
        println("DetailA with name $name executing printDetails()")
    }
}

class DetailB(var id : Number) : AbstractDetail()

fun DetailB.runTests() {
    println("DetailB with ID $id executing runTests()")
}

class DetailC(var list : MutableList<Double>) : AbstractDetail() {
    fun addRandomElement() {
        list.add(Math.random())
    }
}

inline fun <reified D : AbstractDetail, T : Any> complexInit(
    factory: (T) -> D,
    parameter: T,
    init: D.() -> Unit = {} // default value is do nothing
): D {
    // complex code you want to hide from API users
    // e. g. not always create new object with factory but use an existing one
    // ...
    val someDetail = factory(parameter)
    someDetail.init()
    return someDetail
}

fun main() {
    complexInit(::DetailA, "A") { printDetail() }
    complexInit(::DetailB, 0L) { runTests() }
    println("Sum of two random elements in DetailC: "
            + complexInit(::DetailC, mutableListOf(Math.random())) { addRandomElement() }.list.sum()
    )
}
