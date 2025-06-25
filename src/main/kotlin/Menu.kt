package app

import java.util.Scanner

class Menu(private val title: String) {
    private val items = mutableListOf<MenuItem>()
    private val scanner = Scanner(System.`in`)

    fun addItem(title: String, action: () -> Unit) {
        items.add(MenuItem(title, action))
    }

    fun show() {
        while (true) {
            println("\n$title")
            items.forEachIndexed { index, item -> println("$index. ${item.title}") }
            print("Выберите пункт меню: ")
            val input = scanner.nextLine()

            val choice = input.toIntOrNull()
            if (choice == null) {
                println("Ошибка: нужно ввести цифру.")
                continue
            }
            if (choice !in items.indices) {
                println("Ошибка: пункта с таким номером нет.")
                continue
            }

            items[choice].action()
            break
        }
    }
}