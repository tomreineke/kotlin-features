package main.kotlin

/*
 * In some sense, sealed classes are similar to enum classes.
 * Sealed classes and interfaces represent restricted class hierarchies that provide more control over inheritance.
 * All direct subclasses of a sealed class are known at compile time. No other subclasses may appear outside a module
 * within which the sealed class is defined. For example, third-party clients can't extend your sealed class in their
 * code. Thus, each instance of a sealed class has a type from a limited set that is known when this class is compiled.
 */

// Try to replace the sealed modifier with the open modifier.
sealed class Item(val name: String)

class Weapon(name: String): Item(name) {
    fun doDamage() {
        println("weapon doing 42 damage.")
    }
}

class Utility(name: String): Item(name) {
    fun doUsefulStuff() {
        println("utility item doing some 08/15 stuff.")
    }
}

class Armor(name: String): Item(name) {
    fun protect() {
        println("armor protecting against 4711 fire damage")
    }
}

fun execute(item: Item) {
    val type = when (item) {
        is Weapon -> { // smart cast to Weapon
            item.doDamage()
            "weapon"
        }
        is Utility -> {
            item.doUsefulStuff()
            "utility"
        }
        is Armor -> {
            item.protect()
            "armor"
        }
    }
    println(type)
}

fun main() {
    execute(Weapon("sword"))
    execute(Utility("scanner"))
    execute(Armor("helmet"))
}
