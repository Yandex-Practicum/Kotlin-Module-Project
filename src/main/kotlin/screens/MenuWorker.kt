package screens

import model.MenuItem

class MenuWorker(private val listOfWhat: String) {

    var menuItems: Map<Int, MenuItem> = mapOf()
    private val goBackMenuItemIndex get() = menuItems.size

    fun showMenu() {
        println()
        println(listOfWhat)
        menuItems.forEach { menuItem ->
            println(menuItem.value.itemName)
        }
        println("$goBackMenuItemIndex. Выход")
    }


    fun performActionOnMenuItemClick(): Boolean {
        val userChoice = requestUserChoice()
        if (userChoice == goBackMenuItemIndex) {
            return true
        }
        menuItems[userChoice]?.action?.invoke()
        return false
    }

    private fun requestUserChoice(): Int {
        var input: String
        var value: Int
        while (true) {
            print("Ваш выбор: ")
            input = readLine()!!

            try {
                value = input.toInt()
            } catch (ex: NumberFormatException) {
                println("Неверный формат ввода. Введите целое число.")
                showMenu()
                continue
            }

            if (value in 0..menuItems.size) {
                return value
            }
            println("Такого пункта меню нет. Введите число от 0 до ${menuItems.size}")
        }
    }
}