abstract class BaseMenu<T>(
    protected val items: MutableList<T>,
    protected val menuUtils: MenuUtils,
    private val itemType: String,
    private val createOption: String
) {

    protected abstract fun menuItemSelected(item: T)

    protected abstract fun createItem()

    fun showMenu() {
        while (true) {
            println("\nСписок $itemType:")
            println("0. $createOption")
            showItems()
            println("${items.size + 1}. Выход")

            val choice = menuUtils.readInput()
            if (choice == items.size + 1) return

            when (choice) {
                0 -> createItem()
                in 1..items.size -> menuItemSelected(items[choice - 1])
                else -> println("Некорректный выбор. Пожалуйста, введите число от 0 до ${items.size + 1}")
            }
        }
    }

    private fun showItems() {
        if (items.isNotEmpty()) {
            items.forEachIndexed { index, item ->
                when (item) {
                    is Pair<*, *> -> println("${index + 1}. ${item.first}")
                    is String -> println("${index + 1}. $item")
                    else -> println("${index + 1}. Неизвестный элемент")
                }
            }
        }
    }
}