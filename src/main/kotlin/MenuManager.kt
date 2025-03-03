import java.util.Scanner

// Класс для работы с меню
class MenuManager(private val title: String) {
    private val scanner = Scanner(System.`in`)
    private val items = mutableListOf<Pair<String, () -> Unit>>()

    // Добавление пункта меню
    fun addItem(name: String, action: () -> Unit) {
        items.add(name to action)
    }

    // Отображение меню и обработка ввода
    fun show(exitCallback: () -> Unit = {}) {
        while (true) {
            println(title)
            items.forEachIndexed { index, pair ->
                println("$index. ${pair.first}")
            }
            println("${items.size}. Выход")

            val input = scanner.nextLine()
            if (input == items.size.toString()) {
                exitCallback() // Вызов callback для выхода
                return
            }

            val choice = input.toIntOrNull()
            if (choice == null || choice !in items.indices) {
                println("Ошибка: введите число от 0 до ${items.size}")
                continue
            }

            items[choice].second() // Выполняем действие
        }
    }
}