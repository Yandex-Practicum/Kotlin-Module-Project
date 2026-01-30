package ui

abstract class Menu<T>(
    private val title: String,
    private val createItemText: String = "Создать",
    private val exitText: String = "Выход"
) {
    private val items = mutableListOf<Pair<String, () -> Unit>>()

    abstract fun getItemsList(): List<T>
    abstract fun getItemName(item: T): String
    abstract fun onItemSelected(item: T)
    abstract fun onCreateItem()

    fun show() {
        while (true) {
            updateMenuItems()
            printMenu()

            val input = ConsoleReader.readLine("Выберите пункт меню: ")

            if (!validateInput(input)) {
                continue
            }

            val choice = input.toInt()

            if (!processChoice(choice)) {
                break
            }
        }
    }

    private fun updateMenuItems() {
        items.clear()
        items.add(Pair(createItemText) { onCreateItem() })

        getItemsList().forEachIndexed { index, item ->
            items.add(Pair(getItemName(item)) { onItemSelected(item) })
        }

        items.add(Pair(exitText) { /* Выход обрабатывается в processChoice */ })
    }

    private fun printMenu() {
        println("\n=== $title ===")
        items.forEachIndexed { index, pair ->
            println("$index. ${pair.first}")
        }
    }

    private fun validateInput(input: String): Boolean {
        if (input.isEmpty()) {
            println("Ошибка: Введите число")
            return false
        }

        val choice = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            println("Ошибка: Введите корректное число")
            return false
        }

        if (choice < 0 || choice >= items.size) {
            println("Ошибка: Пункт $choice не существует. Выберите от 0 до ${items.size - 1}")
            return false
        }

        return true
    }

    private fun processChoice(choice: Int): Boolean {
        if (choice == items.size - 1) {
            return false // Выход
        }

        items[choice].second.invoke()
        return true
    }
}