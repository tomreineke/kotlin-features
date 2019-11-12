package main.kotlin

fun execute(item: Item) {
    val type = when (item) {
        is Weapon -> {
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