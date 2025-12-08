import java.util.Scanner

data class MenuItem(
    val name: String,
    val action: () -> Unit
)

class Menu(
    private val title: String,
    private val scanner: Scanner,
    private val items: MutableList<MenuItem>,
    private val exitAction: () -> Unit = {}
) {
    fun show() {
        var shouldContinue = true

        while (shouldContinue) {
            printMenu()
            shouldContinue = handleInput()
        }
    }

    private fun printMenu() {
        println("\n=== $title ===")

        if (items.isEmpty()) {
            println("Список пуст")
        } else {
            items.forEachIndexed { index, item ->
                println("${index + 1}. ${item.name}")
            }
        }

        println("0. ${if (title == "Список архивов") "Выход" else "Назад"}")
        print("Выберите пункт меню: ")
    }

    private fun handleInput(): Boolean {
        val input = scanner.nextLine().trim()
        val choice = input.toIntOrNull()

        return when {
            choice == null -> {
                println("Ошибка: необходимо ввести число. Получено: '$input'")
                true // Продолжаем показ меню
            }
            choice == 0 -> {
                exitAction()
                false // Завершаем показ этого меню
            }
            choice > 0 && choice <= items.size -> {
                items[choice - 1].action()
                false // После выполнения действия выходим из этого меню
            }
            else -> {
                println("Ошибка: пункта с номером $choice не существует")
                true // Продолжаем показ меню
            }
        }
    }
}