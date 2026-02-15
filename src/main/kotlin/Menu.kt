class Menu<T>(
    private val title: String,
    private val items: MutableList<T>,
    private val itemToString: (T) -> String,
    private val onCreate: () -> Unit,
    private val onSelect: (T) -> Unit,
    private val exitText: String = "Выход"
) {
    private val input = InputUtils()

    fun show() {
        while (true) {
            println("\n--- $title ---")
            println("0. Создать...")

            items.forEachIndexed { index, item ->
                println("${index + 1}. ${itemToString(item)}")
            }

            val exitIndex = items.size + 1
            println("$exitIndex. $exitText")

            println("\nВведите номер пункта:")

            val choice = input.readInt()

            if (choice == null) {
                println("Ошибка: введите число.")
                continue
            }

            when (choice) {
                0 -> onCreate()
                exitIndex -> return
                in 1..items.size -> onSelect(items[choice - 1])
                else -> println("Такого пункта нет. Введите корректное число.")
            }
        }
    }
}