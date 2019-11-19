package main.kotlin

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