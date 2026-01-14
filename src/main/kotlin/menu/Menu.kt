package menu

import java.util.Scanner

class Menu(
    private val title: String,
    private val items: List<MenuItem>
) {
    private val scanner = Scanner(System.`in`)

    fun show() {
        while (true) {
            println()
            println(title)

            for (i in items.indices) {
                println("$i. ${items[i].title}")
            }

            print("Введите номер: ")
            val input = scanner.nextLine()

            if (input.toIntOrNull() == null) {
                println("Ошибка: нужно ввести цифру")
                continue
            }

            val choice = input.toInt()

            if (choice < 0 || choice >= items.size) {
                println("Ошибка: такого пункта нет")
                continue
            }

            items[choice].action()
            break
        }
    }
}
