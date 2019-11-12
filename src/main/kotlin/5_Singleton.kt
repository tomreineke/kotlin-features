package main.kotlin

import kotlin.AssertionError

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

interface Checker {
    fun validate(item: Item)
}

object WeaponChecker : Checker {
    override fun validate(item: Item) {
        if (item.name.isEmpty()) {
            throw AssertionError(item)
        }
    }
}

fun main() {
    WeaponChecker.validate(Weapon("sword"))
    WeaponChecker.validate(Weapon(""))
}