package main.kotlin

import kotlin.AssertionError

/*
 * Singletons exist out of the box in Kotlin. Simply use object as a construct.
 */

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
