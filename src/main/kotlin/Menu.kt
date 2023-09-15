class Menu(private val items: List<Pair<String, () -> Unit>>) {
    fun show() {
        while (true) {
            println("Меню:")
            for ((index, item) in items.withIndex()) {
                println("${index + 1}. ${item.first}")
            }
            println("0. Выход")

            val input = readLine()?.toIntOrNull()

            when (input) {
                null -> {
                    println("Пожалуйста, введите корректное значение")
                }
                0 -> return
                in 1..items.size -> {
                    val selectedItem = items[input - 1]
                    selectedItem.second()
                }
                else -> {
                    println("Пожалуйста, введите корректное значение")
                }
            }
        }
    }
}
