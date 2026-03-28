package menu

import java.util.Scanner

class Menu(
    private val title: String,
    private val items: MutableList<Pair<String, () -> Unit>> = mutableListOf()
) {
    private val scanner = Scanner(System.`in`)

    fun addItem(name: String, action: () -> Unit) {
        items.add(name to action)
    }

    fun show() {
        while (true) {
            println(" $title ")
            items.forEachIndexed { index, item ->
                println("${index + 1}. ${item.first}")
            }

            print("Введите номер пункта: ")
            val input = scanner.nextLine()

            val choice = input.toIntOrNull()
            if (choice == null) {
                println("Ошибка: нужно вводить цифру.")
                continue
            }

            if (choice !in 1..items.size) {
                println("Ошибка: пункта с таким номером нет.")
                continue
            }

            items[choice - 1].second.invoke()
            break
        }
    }
}
