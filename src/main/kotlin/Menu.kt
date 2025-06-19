abstract class Menu<T> {
    protected abstract val items: List<T>
    protected abstract val createItemText: String
    protected abstract val menuTitle: String
    protected abstract val exitText: String

    protected abstract fun displayItem(item: T): String
    protected abstract fun onCreateItem()
    protected abstract fun onItemSelected(item: T)

    fun show() {
        while (true) {
            val menuItems = mutableListOf<String>().apply {
                add(createItemText)
                addAll(items.map { displayItem(it) })
            }

            println("\n$menuTitle:")
            menuItems.forEachIndexed { index, item ->
                println("$index. $item")
            }
            println("${menuItems.size}. $exitText")

            when (val choice = getUserChoice(menuItems.size)) {
                menuItems.size -> return
                0 -> onCreateItem()
                else -> onItemSelected(items[choice - 1])
            }
        }
    }

    private fun getUserChoice(maxItem: Int): Int {
        while (true) {
            print("\nВыберите пункт: ")
            val input = readlnOrNull()

            if (input.isNullOrBlank()) {
                println("Пожалуйста, введите число")
                continue
            }

            try {
                val choice = input.toInt()
                if (choice in 0..maxItem) {
                    return choice
                } else {
                    println("Число должно быть от 0 до $maxItem")
                }
            } catch (e: NumberFormatException) {
                println("Пожалуйста, введите корректное число")
            }
        }
    }

    protected fun readNonEmptyInput(prompt: String): String {
        while (true) {
            print(prompt)
            val input = readlnOrNull()?.trim()
            if (!input.isNullOrEmpty()) {
                return input
            }
            println("Поле не может быть пустым. Пожалуйста, введите значение.")
        }
    }
}