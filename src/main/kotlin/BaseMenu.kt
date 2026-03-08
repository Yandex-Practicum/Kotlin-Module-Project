import java.util.Scanner

abstract class BaseMenu(val title: String) {
    val scanner = Scanner(System.`in`)

    val menuItems = mutableListOf<Pair<String, () -> Unit>>()

    fun show() {
        while (true) {
            println("\n$title ")
            menuItems.forEachIndexed { index, item -> println("$index. ${item.first}") }
            println("${menuItems.size} Выход")

            val input = scanner.nextLine()
            val choice = input.toIntOrNull()

            if (choice == menuItems.size) return

            if (choice != null && choice in menuItems.indices) {
                menuItems[choice].second()
            } else {
                println("Пу пу пу, нужна цифра от 0 до ${menuItems.size}")
            }
        }
    }

    // Универсальный метод для ввода текста
    protected fun inputNonEmpty(prompt: String): String {
        while (true) {
            println(prompt)
            val text = scanner.nextLine().trim()
            if (text.isNotEmpty()) return text
            println("Напиши что нибудь")
        }
    }
}