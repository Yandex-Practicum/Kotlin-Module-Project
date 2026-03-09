


import java.util.Scanner


class Menu(private val title: String) {

    private val items = mutableListOf<MenuItem>()
    private val scanner = Scanner(System.`in`)

    fun addItem(title: String, exit: Boolean = false, action: () -> Unit) {
        items.add(MenuItem(title, action, exit))
    }

    fun show() {

        loop@ while (true) {

            println("\n$title")

            items.forEachIndexed { index, item ->
                println("$index. ${item.title}")
            }

            val input = scanner.nextLine()
            val number = input.toIntOrNull()

            if (number == null) {
                println("Введите цифру")
                continue
            }

            if (number !in items.indices) {
                println("Такой цифры нет")
                continue
            }

            val item = items[number]

            item.action()

            if (item.exit) {
                break
            }
        }
    }
}