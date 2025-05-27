class Menu<T>(
    private val title: String,
    private val items: MutableList<T>,
    private val itemToString: (T) -> String = { it.toString() },
    private val onItemSelected: (T) -> Unit,
    private val onCreate: (() -> Boolean)? = null,
    private val onExit: (() -> Unit)? = null,
    private val createItemText: String = "Создать новый" // Новый параметр для текста создания
) {
    fun show() {
        while (true) {
            println("\n$title")

            if (items.isEmpty()) {
                println("Список пуст.") // Универсальное сообщение о пустом списке
            }

            println("1. $createItemText") // Используем переданный текст
            items.forEachIndexed { index, item ->
                println("${index + 2}. ${itemToString(item)}")
            }
            println("${items.size + 2}. Выход")

            print("Выберите пункт: ")
            val input = readLine()
            val option = input?.toIntOrNull()

            if (option == null) {
                println("Пожалуйста, введите число.")
                continue
            }

            when (option) {
                1 -> {
                    val shouldExit = onCreate?.invoke() ?: false
                    if (shouldExit) return
                }
                in 2..(items.size + 1) -> onItemSelected(items[option - 2])
                items.size + 2 -> {
                    onExit?.invoke()
                    return
                }
                else -> println("Некорректный ввод, попробуйте ещё раз.")
            }
        }
    }
}