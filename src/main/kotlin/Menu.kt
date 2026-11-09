class MenuItem(
    val title: String,
    val action: () -> Boolean
)

class Menu(
    private val title: String,
    // Возвращение списка
    private val itemsProvider: () -> List<MenuItem>
) {
    fun show() {
        var isRunning = true

        while (isRunning) {
            // список пунктов
            val items = itemsProvider()

            println("\n$title")
            for (i in items.indices) {
                println("$i. ${items[i].title}")
            }

            print("Введите номер пункта меню: ")
            val input = readLine()?.trim()
            val index = input?.toIntOrNull()

            if (index == null) {
                println("Ошибка: необходимо ввести цифру. Попробуйте снова.")
                continue
            }

            if (index !in items.indices) {
                println("Ошибка: пункта с таким номером нет. Попробуйте снова.")
                continue
            }

            isRunning = items[index].action()
        }
    }
}