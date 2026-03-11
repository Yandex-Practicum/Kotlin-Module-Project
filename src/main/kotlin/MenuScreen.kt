class MenuScreen(
    private val title: String,              // Заголовок - "Список архивов:"
    private val items: List<MenuItem>,      // список к выбору
    //private val onExit: () -> Unit = {}     // действие при выходе
) {
    data class MenuItem(
        val text: String,          // элементы меню
        val action: () -> Unit     // действие при выборе элемента меню
    )

    private val scanner = java.util.Scanner(System.`in`)
    fun show() {
        while (true) {
            println("$title")
            items.forEachIndexed { index, item ->
                println("$index. ${item.text}")
            }
            print("Выберите пункт меню: ")

            val input = scanner.nextLine().trim()

            val selectedIndex = input.toIntOrNull()

            when {
                selectedIndex == null -> {
                    println("Ошибка: нужно ввести число.")
                }

                selectedIndex < 0 || selectedIndex >= items.size -> {
                    println("Ошибка: такого пункта нет. Выберите число от 0 до ${items.size - 1}")
                }

                else -> {
                    val selectedItem = items[selectedIndex]
                    selectedItem.action()                     // выполняем действие пункта меню
                    return
                }
            }
        }

    }

    companion object {
        fun exitItem(onExit: () -> Unit) = MenuItem("Выход") { onExit() }
    }
}