import java.util.Scanner

abstract class Menu(val title: String) {
    private val scanner = Scanner(System.`in`)

    // Метод, который каждый экран реализует по-своему
    abstract fun show()

    // Универсальный метод отрисовки меню и обработки выбора
    fun <T> runMenu(
        items: List<T>,
        getItemName: (T) -> String,
        onSelect: (T) -> Unit,
        onCreate: () -> Unit,
        exitText: String
    ) {
        while (true) {
            println("\n--- $title ---")
            println("0. Создать")
            items.forEachIndexed { index, item ->
                println("${index + 1}. ${getItemName(item)}")
            }
            println("${items.size + 1}. $exitText")

            val input = scanner.nextLine()
            val choice = input.toIntOrNull()

            when {
                choice == 0 -> onCreate()
                choice == items.size + 1 -> return // Выход из текущего меню
                choice != null && choice in 1..items.size -> onSelect(items[choice - 1])
                else -> println("Ошибка: введите число из списка.")
            }
        }
    }

    // Универсальный метод для безопасного ввода текста
    fun readNonEmptyString(prompt: String): String {
        while (true) {
            println(prompt)
            val input = scanner.nextLine().trim()
            if (input.isNotEmpty()) return input
            println("Ошибка: поле не может быть пустым.")
        }
    }
}