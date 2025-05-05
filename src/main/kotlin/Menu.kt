abstract class Menu<T>(private val title: String) {
    abstract fun getItems(): List<T>
    abstract fun createItem()
    abstract fun handleItemSelected(item: T)

    fun show() {
        while (true) {
            println("\n$title:")
            println("0. Создать")
            getItems().forEachIndexed { index, item -> println("${index + 1}. ${item}") }
            println("${getItems().size + 1}. Выход")

            when (val choice = readChoice(getItems().size + 1)) {
                0 -> createItem()
                getItems().size + 1 -> return
                else -> handleItemSelected(getItems()[choice - 1])
            }
        }
    }

    private fun readChoice(max: Int): Int {
        while (true) {
            print("Выберите пункт: ")
            val input = readlnOrNull()?.toIntOrNull()
            when {
                input == null -> println("Введите число!")
                input in 0..max -> return input
                else -> println("Некорректный выбор, попробуйте снова")
            }
        }
    }
}