import java.util.Scanner

class SelectionMenu<T>(
    private val title: String,
    private val items: List<T>,
    private val itemDisplay: (T) -> String
) {
    companion object {
        val scanner = Scanner(System.`in`)

        fun readInput(
            prompt: String,
            validator: (String) -> Boolean = { it.isNotBlank() }): String {
            while (true) {
                print(prompt)
                val input = scanner.nextLine().trim()
                if (validator(input)) {
                    return input
                }
                println("Ошибка: ввод не может быть пустым")
            }
        }
    }

    fun show(onItemSelected: (T) -> Unit, onCreate: () -> Unit): Boolean {
        while (true) {
            println("\n$title")
            println("-".repeat(title.length))

            println("0. Создать")
            println("1. Выход")

            if (items.isEmpty()) {
                println("\nЭлементы отсутствуют")
            } else {
                println("\nСписок:")
                items.forEachIndexed { index, item ->
                    println("${index + 2}. ${itemDisplay(item)}")
                }
            }

            print("Выберите пункт меню: ")
            val input = scanner.nextLine()

            try {
                val choice = input.toInt()
                when (choice) {
                    0 -> onCreate()
                    1 -> return false
                    in 2..items.size + 1 -> onItemSelected(items[choice - 2])
                    else -> println("Ошибка: пункт с номером $choice не существует." +
                            " Выберите от 0 до ${items.size + 1}")
                }
            } catch (e: NumberFormatException) {
                println("Ошибка: пожалуйста, введите число от 0 до ${items.size + 1}")
            }
        }
    }
}
